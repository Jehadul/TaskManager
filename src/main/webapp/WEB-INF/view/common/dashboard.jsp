	<div class="wrap-content container" id="container">
		<!-- start: PAGE TITLE -->
		<section id="page-title">
			<div class="row">
				<div class="col-sm-8">
					<h1 class="mainTitle">Dashboard</h1>
					<span class="mainDescription">Your dashboard</span>
				</div>
				<ol class="breadcrumb">
					<li>
						<span>Home</span>
					</li>
					<li class="active">
						<span>Dashboard</span>
					</li>
				</ol>
			</div>
		</section>
		<!-- end: PAGE TITLE -->
		<!-- start: YOUR CONTENT HERE -->
		<div class="container-fluid container-fullw">
			<div class="row">
				<div class="col-md-12">
					<h5 class="over-title margin-bottom-15"><span class="text-bold">Employees</span></h5>
					<div class="row">
						<div class="col-md-12 space20">
							<button class="btn btn-green add-row">
								Add New <i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped table-hover" id="sample_2" style="width:100%;">
							<thead>
								<tr>
									<th>Code</th>
									<th>Namw</th>
									<th>Designation</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								@foreach ($cmp as $e) 
								<tr>
									<td>{{$e->company_code}}</td>
									<td>{{$e->company_name}}</td>
									<td>{{$e->addr}}</td>
									<td>
									<a href="#" class="edit-row">
										Edit
									</a></td>
									<td>
									<a href="#" class="delete-row">
										Delete
									</a></td>
								</tr>
								@endforeach
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- end: YOUR CONTENT HERE -->
	</div>

	
	<script>
		InitHandlers();
		InitDataTable("#sample_2");
	</script>