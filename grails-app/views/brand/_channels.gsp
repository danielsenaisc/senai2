<!DOCTYPE html>
<!-- AUDIENCE -->
<div class="portlet box blue-madison">
	<div class="portlet-title">
		<div class="caption">
			<g:message code="brand.form.edit.channels"/>
			<a href="javascript:;" class="popovers" data-container="body" data-trigger="hover" 
			data-content="<g:message code="popovers.title"/>" data-original-title="<g:message code="popovers.info"/>" data-placement="top">
				<i class="fa fa-info-circle popovers" ></i> 
			</a>
		</div>
		<div class="actions">
			<button id="channels_table_new" class="btn btn-default btn-sm">
				<i class="glyphicon glyphicon-plus"></i><g:message code="brand.form.action.new"/>
			</button>
			
		</div>
	</div>

	<div class="portlet-body form">
		
		<div class="portlet-body">

			<table class="table table-striped table-hover" id="channels_table">
				<thead>
				<tr>
					
					<th>
						 <g:message code="brand.table.column.channel.type"/>
					</th>
					<th>
						 <g:message code="brand.table.column.channel.url"/>
					</th>
					<th>
						 <g:message code="brand.table.column.channel.location"/>
					</th>
					<th>
						 <g:message code="brand.table.column.channel.description"/>
					</th>

					<th >
					</th>

				</tr>
				</thead>
				<tbody>
				<g:each var="channel" in="${channelList}" status="i">
					<tr class="odd gradeX">
						
						<td>
								<select class="form-control input-small">
                                                                    <g:each var="canal" in="${listaDeCanais}">
									<option><g:message code="${canal.getDescricao()}"/></option>
                                                                    </g:each>
								</select>
						</td>
						<td>
							<input type="text" class="form-control input-medium" style="margin-left:40px;" value="${channel.getFormaAcesso()}" name="teste">
						</td>
						<td>
								<select class="form-control input-small">
									<option><g:message code="brand.form.edit.all"/></option>
									<option><g:message code="brand.form.edit.brazil"/></option>
									<option><g:message code="brand.form.edit.eua"/></option>
								</select>
						</td>
						<td>
                                                    <input type="text" class="form-control input-medium" style="margin-left:40px;" value="${channel.getObservacoes()}">
						</td>
						
						<td>	
							<a class="delete" href="javascript:;">
							<i class="glyphicon glyphicon-remove"><span></span></i> 
							</a>
						</td>
					</tr>
				</g:each>	
				
				</tbody>
			</table>	
		</div>
	</div>
</div>

<script>
	jQuery(document).ready(function() {   
		
		ChannelsTableManaged.init('canais', 'channels_table');

	});
</script>