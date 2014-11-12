<!DOCTYPE html>

<div class="portlet-title">
		
	<div class="actions">
		<a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:null])}" class="btn btn-default red btn-sm">
			<i class="fa fa-pencil">
				</i> <g:message code="brand.form.action.new"/> 
		</a>
		<div class="btn-group">
			<a class="btn btn-default grey-default btn-sm" href="#" data-toggle="dropdown">
				<i class="fa fa-cogs"></i> <g:message code="product.form.actions"/> <i class="fa fa-angle-down"></i>
			</a>
			<ul class="dropdown-menu pull-right">
				<li>
					<a href="#">
					<i class="fa fa-plus-circle"></i> <g:message code="product.form.actions.enable"/> </a>
				</li>
				<li>
					<a href="#">
					<i class="fa fa-minus-circle"></i> <g:message code="product.form.actions.disable"/> </a>
				</li>
			</ul>
			
		</div>
		
	</div>
</div>

<div class="portlet-body">

	<table class="table table-striped table-hover" id="models_table">
		<thead>
		<tr>
			
			<th width="200px">
				 <g:message code="models.table.column.name"/>
			</th>
			<th width="200px">
				 <g:message code="models.table.column.brand"/>
			</th>
			<th >
				 <g:message code="models.table.column.category"/>
			</th>
			<th>
				 <g:message code="models.table.column.updated-at"/>
			</th>
			<th >
				 <g:message code="models.table.column.collection"/>
			</th>
			<th >
				 <g:message code="models.table.column.product"/>
			</th>
			<th >
				 <g:message code="models.table.column.grade"/>
			</th>
			<th >
				 <g:message code="models.table.column.status"/>
			</th>

			<th class="table-checkbox">
				<input type="checkbox" class="group-checkable" data-set="models_table .checkboxes"/>
			</th>

		</tr>
		</thead>
		<tbody>
		<g:each var="modeling" in="${modelingList}" status="i">
			<tr class="odd gradeX">
				
				<td>
					<a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${modeling.getNome()}
					</a>
				</td>
				<td>
					<a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${modeling.getMarcaList().size()}</a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${modeling.getCategoriaList().size()} </a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${modeling} </a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${innerModelingControl.getQuantidadeDeColecoes(modeling)} </a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${innerModelingControl.getQuantidadeDeProdutos(modeling)} </a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${modeling} </a>
				</td>
				<td><a href="${createLink(controller:'modeling',action:'edit',params:[modelingId:modeling.getId()])}" class="t-column">
					 ${innerModelingControl.getStatusTratado(modeling)} </a>
				</td>
				
				<td>
					<input type="checkbox" class="checkboxes" value="1"/>
				</td>
			</tr>
		</g:each>	
		

		</tbody>
	</table>	


</div>
<script>
	jQuery(document).ready(function() {   
		
		ModelsTableManaged.init('modelagem', 'models_table');

	});
</script>