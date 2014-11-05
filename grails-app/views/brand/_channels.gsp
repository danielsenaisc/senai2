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
                    <g:each var="brandChannel" in="${brandChannelList}" status="i">
                        <tr class="odd gradeX">
                            <td>
                                <g:select name="brandChannelTypeListComboBox" from="${channelList}" value="${brandChannel.getCanalId()}" class="form-control input-small"/>
                            </td>
                            <td>
                                <input name="brandChannel" type="text" class="form-control input-medium" style="margin-left:40px;" value="${brandChannel.getFormaAcesso()}">
                            </td>
                            <td>
                                <g:select name="brandChannelLocalizationListComboBox" from="${audienceList}" value="${brandChannel.getAbrangenciaId()}" class="form-control input-small"/>
                            </td>
                            <td>
                                <input name="brandChannelDescription" type="text" class="form-control input-medium" style="margin-left:40px;" value="${brandChannel.getObservacoes()}">
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