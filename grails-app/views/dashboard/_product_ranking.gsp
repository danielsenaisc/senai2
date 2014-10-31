<!DOCTYPE html>
<div class="portlet box blue-madison">
	<div class="portlet-title">
		<div class="caption">
			<i class="icon-trophy"></i><g:message code="dashboard.form.productranking"/>
		</div>
		
	</div>

	<div class="portlet-body">


		<table class="table table-hover table-dashboard-head" >
			<tr>
				<th style="width:30px;">
					 P
				</th>
				<th style="width:90px;">
					<g:message code="dashboard.form.productranking.product"/>
				</th>
				<th>
					<g:message code="dashboard.form.productranking.collection"/>
				</th>
				<th style="width:86px;">
					<g:message code="dashboard.form.productranking.compare"/>
				</th>
				<th style="width:70px;">
					<g:message code="dashboard.form.productranking.shares"/>
				</th>
				<th>
					<g:message code="dashboard.form.productranking.likes"/>
				</th>
				<th>
				</th>	
			</tr>
		</table>


		<div class="table-scrollable table-dashboard-body" >
			<table class="table table-striped table-hover" >
			<thead>
			
			</thead>
			<tbody>
				<g:each var="product" in="${productRankingList}" status="i">
					<tr>

						<td style="width:30px;">
							 ${i+1}
						</td>
						<td style="width:100px;">
							 ${product.getNome()}
						</td>
						<td style="width:110px;">
							 ${product.getColecaoId().getNome()}
						</td>
						<td style="width:110px;">
							 TODO
						</td>
						<td style="width:120px;">
							 TODO
						</td>
						<td>
							 ${product.getLikes()}
						</td>
						
						
						<td>
							<a href="${createLink(controller:'product',action:'edit',params:[id:i])}"><i class="fa fa-edit"></i></a>
						</td>

					</tr>
				</g:each>
			</tbody>
			</table>
		</div>
	</div>
</div>