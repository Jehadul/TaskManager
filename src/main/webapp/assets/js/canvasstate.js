// By Simon Sarris
// www.simonsarris.com
// sarris@acm.org
//
// Last update December 2011
//
// Free to use and distribute at will
// So long as you are nice to people, etc

// Constructor for Shape objects to hold data for all drawn objects.
// For now they will just be defined as rectangles.
function Shape(x, y, w, h, imgSrc, text) {
  // This is a very simple and unsafe constructor. All we're doing is checking if the values exist.
  // "x || 0" just means "if there is a value for x, use that. Otherwise use 0."
  // But we aren't checking anything else! We could put "Lalala" for the value of x 
  this.x = x || 0;
  this.y = y || 0;
  this.w = w || 10;
  this.h = h || 10;
  
  this.text = text;
  this.imgSrc = imgSrc;
  this.img = null;
}

// Draws this shape to a given context
Shape.prototype.draw = function(ctx) {
  if(this.img){
    ctx.drawImage(this.img, 0, 0, this.img.width, this.img.height,this.x, this.y, this.w, this.h);
    ctx.fillStyle = "#333";
    ctx.font="14px Helvetica, Arial, sans-serif";
    ctx.fillText(this.text,this.x + 9, this.y + 21);
  }
}

// Determine if a point is inside the shape's bounds
Shape.prototype.contains = function(mx, my) {
  // All we have to do is make sure the Mouse X,Y fall in the area between
  // the shape's X and (X + Height) and its Y and (Y + Height)
  return  (this.x <= mx) && (this.x + this.w >= mx) &&
  (this.y <= my) && (this.y + this.h >= my);
}

Shape.prototype.anchorHit = function(mx, my) {

    var dx, dy;

    // top-left
    dx = mx - this.x;
    dy = my - this.y;
    if (dx * dx + dy * dy <= 100) {
        return (0);
    }
    // top-right
    dx = mx - (this.x + this.w);
    dy = my - this.y;
    if (dx * dx + dy * dy <= 10) {
        return (1);
    }
    // bottom-right
    dx = mx - (this.x + this.w);
    dy = my - (this.y + this.h);
    if (dx * dx + dy * dy <= 10) {
        return (2);
    }
    // bottom-left
    dx = mx - this.x;
    dy = my - (this.y + this.h);
    if (dx * dx + dy * dy <= 10) {
        return (3);
    }
    return (-1);

};

function CanvasState(canvas) {
  // **** First some setup! ****
  
  this.canvas = canvas;
  this.width = canvas.width;
  this.height = canvas.height;
  this.ctx = canvas.getContext('2d');
  // This complicates things a little but but fixes mouse co-ordinate problems
  // when there's a border or padding. See getMouse for more detail
  var stylePaddingLeft, stylePaddingTop, styleBorderLeft, styleBorderTop;
  if (document.defaultView && document.defaultView.getComputedStyle) {
    this.stylePaddingLeft = parseInt(document.defaultView.getComputedStyle(canvas, null)['paddingLeft'], 10)      || 0;
    this.stylePaddingTop  = parseInt(document.defaultView.getComputedStyle(canvas, null)['paddingTop'], 10)       || 0;
    this.styleBorderLeft  = parseInt(document.defaultView.getComputedStyle(canvas, null)['borderLeftWidth'], 10)  || 0;
    this.styleBorderTop   = parseInt(document.defaultView.getComputedStyle(canvas, null)['borderTopWidth'], 10)   || 0;
  }


  // Some pages have fixed-position bars (like the stumbleupon bar) at the top or left of the page
  // They will mess up mouse coordinates and this fixes that
  var html = document.body.parentNode;
  this.htmlTop = html.offsetTop;
  this.htmlLeft = html.offsetLeft;

  // **** Keep track of state! ****
  
  this.valid = false; // when set to false, the canvas will redraw everything
  this.shapes = [];  // the collection of things to be drawn
  this.dragging = false; // Keep track of when we are dragging
  this.draggingResizer = -1; 
  // the current selected object. In the future we could turn this into an array for multiple selection
  this.selection = null;
  this.dragoffx = 0; // See mousedown and mousemove events for explanation
  this.dragoffy = 0;
  
  // **** Then events! ****
  
  // This is an example of a closure!
  // Right here "this" means the CanvasState. But we are making events on the Canvas itself,
  // and when the events are fired on the canvas the variable "this" is going to mean the canvas!
  // Since we still want to use this particular CanvasState in the events we have to save a reference to it.
  // This is our reference!
  var myState = this;
  
  //fixes a problem where double clicking causes text to get selected on the canvas
  canvas.addEventListener('selectstart', function(e) { e.preventDefault(); return false; }, false);
  // Up, down, and move are for dragging
  canvas.addEventListener('mousedown', function(e) {
    var mouse = myState.getMouse(e);
    var mx = mouse.x;
    var my = mouse.y;
    var shapes = myState.shapes;
    var l = shapes.length;
    for (var i = l-1; i >= 0; i--) {
      var resizer = shapes[i].anchorHit(mx, my);
      if (shapes[i].contains(mx, my) || resizer >= 0 ) {
        var mySel = shapes[i];
        // Keep track of where in the object we clicked
        // so we can move it smoothly (see mousemove)

        myState.dragoffx = mx - mySel.x;
        myState.dragoffy = my - mySel.y;

        if(resizer >= 0)
        {
          myState.draggingResizer = resizer;
        }
        else{
          myState.dragging = true;
        }
        
        myState.selection = mySel;
        myState.valid = false;
        return;
      }
    }
    // havent returned means we have failed to select anything.
    // If there was an object selected, we deselect it
    if (myState.selection) {
      myState.selection = null;
      myState.valid = false; // Need to clear the old selection border
    }


  }, true);
  canvas.addEventListener('mousemove', function(e) {
    var mouse = myState.getMouse(e);
    if (myState.dragging || myState.draggingResizer > -1){
      // We don't want to drag the object by its top-left corner, we want to drag it
      // from where we clicked. Thats why we saved the offset and use it here
      var newX = mouse.x - myState.dragoffx;
      var newY = mouse.y - myState.dragoffy;
        // Something's dragging so we must redraw
    
      if (myState.draggingResizer > -1) {
        // resize the image
        switch (myState.draggingResizer) {
          case 0:
            //top-left
            myState.selection.w += myState.selection.x - newX;
            myState.selection.h += myState.selection.y - newY;
            myState.selection.x = newX;
            myState.selection.y = newY;   
            break;
          case 1:
            //top-right
            myState.selection.w = mouse.x - myState.selection.x;
            myState.selection.h += myState.selection.y - newY;
            myState.selection.y = newY;   
            break;
          case 2:
            //bottom-right
            myState.selection.w = mouse.x - myState.selection.x;
            myState.selection.h = mouse.y - myState.selection.y;
            break;
          case 3:
            //bottom-left
            myState.selection.w += myState.selection.x - newX;
            myState.selection.h = mouse.y - myState.selection.y;
            myState.selection.x = newX;
            break;
        }
      }
      else{
        myState.selection.x = newX;
        myState.selection.y = newY;   
      }
      myState.valid = false;
    } 
  }, true);
  canvas.addEventListener('mouseup', function(e) {
    myState.dragging = false;
    if(myState.selection && myState.draggingResizer == 0){
      myState.removeShape(myState.selection);
      myState.selection = null;
    }
    myState.draggingResizer = -1;
  }, true);
  // double click for making new shapes
  canvas.addEventListener('dblclick', function(e) {
     if(myState.selection){
      var text = prompt("Please enter text", "");
      if(text == null){
        return;
      }
      myState.selection.text = text;
      myState.valid = false;      
    }   
  }, true);
  
  // **** Options! ****
  
  this.selectionColor = '#00c';
  this.selectionWidth = 1;  
  this.interval = 30;
  setInterval(function() { myState.draw(); }, myState.interval);
}

CanvasState.prototype.addShape = function(shape) {
  this.shapes.push(shape);
  thisCanvas = this;
  var img = new Image();
  img.onload = function () {
    shape.img = img;
    thisCanvas.valid = false;
  }
  img.src = shape.imgSrc;
}

CanvasState.prototype.removeShape = function(shape) {
  var index = this.shapes.indexOf(shape);
  this.shapes.splice(index, 1);
  this.valid = false;
}

CanvasState.prototype.clear = function() {
  this.ctx.clearRect(0, 0, this.width, this.height);
}

// While draw is called as often as the INTERVAL variable demands,
// It only ever does something if the canvas gets invalidated by our code
CanvasState.prototype.draw = function() {
  // if our state is invalid, redraw and validate!
  if (!this.valid) {
    var ctx = this.ctx;
    var shapes = this.shapes;
    this.clear();
    
    this.ctx.beginPath();
    this.ctx.rect(0, 0, canvas.width, canvas.height);
    this.ctx.fillStyle = "#fff";
    ctx.closePath();
    this.ctx.fill();
    // ** Add stuff you want drawn in the background all the time here **
    
    // draw all shapes
    var l = shapes.length;
    for (var i = 0; i < l; i++) {
      var shape = shapes[i];
      // We can skip the drawing of elements that have moved off the screen:
      if (shape.x > this.width || shape.y > this.height ||
        shape.x + shape.w < 0 || shape.y + shape.h < 0) continue;
        shapes[i].draw(ctx);
    }
    
    // draw selection
    // right now this is just a stroke along the edge of the selected Shape
    if (this.selection != null) {
      ctx.strokeStyle = this.selectionColor;
      ctx.lineWidth = this.selectionWidth;
      var mySel = this.selection;
      ctx.strokeRect(mySel.x,mySel.y,mySel.w,mySel.h);
      this.ctx.fillStyle = "#f00";      
      ctx.beginPath();
      ctx.arc(mySel.x, mySel.y, 5, 0, Math.PI * 2, false);
      ctx.closePath();
      ctx.fill();
      this.ctx.fillStyle = "#0f0";
      ctx.beginPath();
      ctx.arc(mySel.x + mySel.w, mySel.y, 5, 0, Math.PI * 2, false);
      ctx.closePath();
      ctx.fill();
      ctx.beginPath();
      ctx.arc(mySel.x, mySel.y + mySel.h, 5, 0, Math.PI * 2, false);
      ctx.closePath();
      ctx.fill();
      ctx.beginPath();
      ctx.arc(mySel.x + mySel.w, mySel.y + mySel.h, 5, 0, Math.PI * 2, false);
      ctx.closePath();
      ctx.fill();
    }
    
    // ** Add stuff you want drawn on top all the time here **
    
    this.valid = true;
  }
}


// Creates an object with x and y defined, set to the mouse position relative to the state's canvas
// If you wanna be super-correct this can be tricky, we have to worry about padding and borders
CanvasState.prototype.getMouse = function(e) {
  var element = this.canvas, offsetX = 0, offsetY = 0, mx, my;
  
  // Compute the total offset
  if (element.offsetParent !== undefined) {
    do {
      offsetX += element.offsetLeft;
      offsetY += element.offsetTop;
    } while ((element = element.offsetParent));
  }

  // Add padding and border style widths to offset
  // Also add the <html> offsets in case there's a position:fixed bar
  offsetX += this.stylePaddingLeft + this.styleBorderLeft + this.htmlLeft;
  offsetY += this.stylePaddingTop + this.styleBorderTop + this.htmlTop;

  mx = e.pageX - offsetX;
  my = e.pageY - offsetY;
  
  // We return a simple javascript object (a hash) with x and y defined
  return {x: mx, y: my};
}

