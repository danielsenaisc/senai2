<!DOCTYPE html>

<div class="portlet box blue-madison">
    <div class="portlet-title">
        <div class="caption">
            <g:message code="collection.form.edit.basic"/>
            <a href="javascript:;" class="popovers" data-container="body" data-trigger="hover" data-content="Como realizar esse cadastro!" data-original-title="Mais informações" data-placement="top">
                <i class="fa fa-info-circle popovers" ></i> 
            </a>
        </div>
    </div>


        <!-- BASIC INFORMATION -->
    <div class="portlet-body form">
        <div role="form" class="form-horizontal">
            <div class="form-body">
                    <!-- NAME -->
                <div class="form-group">
                    <div class="col-md-8">
                            <!-- NAME -->
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="collection.table.column.name"/></label>
                            <div class="col-md-3">
                                <div class="input-icon right">
                                    <input id="collection_name" type="text" class="form-control input-small col-wid399" tabindex="1" name="collectionName" value="${collection.getNome()}">
                                </div>
                            </div>
                        </div>
                        <!-- BRAND -->
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="collection.form.edit.brand"/></label>
                            <div class="col-md-8" style="margin-right: 10px; margin-left: 12px;">
                                <div class="form-group">                                    
                                    <g:select name="brandListComboBox" from="${brandList}" value="${collection.getMarcaId()}" class="form-control input-medium brand-select" tabindex="2" />
                                </div>
                            </div>
                        </div>

                                                <!-- CODE -->
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="collection.form.edit.code"/></label>
                            <div class="col-md-3">
                                <div class="input-icon right">
                                    <input name="collectionFreeId" type="text" class="form-control input-xlarge col-wid399" tabindex="3"  value="${collection.getIdLivre()}">
                                </div>
                            </div>
                        </div>

                                                <!-- VIGENCIA -->
                        <div class="form-group">
                            <div class="col-md-8">
                                <label class="col-md-4 control-label"><g:message code="collection.form.edit.period"/></label>
                                <div class="col-md-3" style="margin-left: 14px;">
                                    <div class="form-group">
                                        <div  class="col-md-4">
                                            <input name="collectionInitalVigence" id="date-picker-start" class="form-control form-control-inline input-small date-picker " size="16" type="text"  value="${innerCollectionControl.getVigenciaInicialTratada(collection)}" tabindex="4"/></i>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-1" >
                                    <i class="fa fa-chevron-right" style="padding-top:16px;padding-left:18px;"></i>
                                </div>

                                <div class="col-md-1" style="margin-left: 0px;">
                                    <div class="form-group">
                                        <div  class="col-md-4">
                                            <input name="collectionFinalVigence" id="date-picker-end" class="form-control form-control-inline input-small date-picker" size="16" type="text" value="${innerCollectionControl.getVigenciaFinalTratada(collection)}" tabindex="5"/></i>
                                        </div>
                                    </div>
                                </div>
                            </div>	
                        </div>	

                                                <!-- DESCRIPTION -->
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="collection.form.edit.description"/></label>
                            <div class="col-md-3">
                                <div class="input-icon right">
                                    <textarea name="collectionDescription" class="form-control input-xlarge col-wid399" rows="7" tabindex="6" maxlength="600" > ${collection.getDescricao()} </textarea>
                                </div>
                            </div>
                        </div>

                                                <!-- TAGS -->
                        <div class="form-group">
                            <label class="control-label col-md-3"><g:message code="collection.form.edit.tags"/></label>
                            <div class="col-md-9 col-wid399" tabindex="7">
                                <input id="collection_tags" type="text" class="form-control tags col-wid399" value="${innerCollectionControl.getListaDeTagsTratada(collection)}" />
                            </div>
                        </div>

                        <div class="form-group ">
                            <label class="control-label col-md-3"><g:message code="collection.form.edit.status"/></label>
                            <div class="col-md-6" style="margin-left: 14px;">
                                <div class="form-group">
                                    <g:select name="statusListComboBox" from="${statusList}" value="${collection.getColecaoStatusId()}" class="form-control input-sm" tabindex="8" />
                                </div>
                            </div>

                        </div>


                    </div>


                    <div class="col-md-3">

                        <div class="form-group ">
                            <div class="col-md-3">
                                <div class="fileinput fileinput-new" data-provides="fileinput">
                                    <div class="fileinput-new thumbnail" style="width: 200px; height: 150px; background-color: #eaeaea;">
                                        <i class="icon-picture" style="font-size:60px;margin-top:60px"></i>
                                    </div>
                                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;">
                                    </div>
                                    <div>
                                        <span class="btn btn-sm blue btn-file">
                                            <span class="fileinput-new">
                                                Selecione uma imagem 
                                            </span>
                                            <span class="btn btn-sm blue fileinput-exists">
                                                Alterar 
                                            </span>
                                            <input type="file" name="..." tabindex="-1">
                                        </span>
                                        <a href="#" class="btn btn-sm red fileinput-exists" data-dismiss="fileinput">
                                            Remover 
                                        </a>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>


                </div>


            </div>

        </div>
    </div>

</div>

<script>
    jQuery(document).ready(function() {   

    $("#collection_tags").select2({
    width: 300,
    'defaultText':'nova tag...',
    tags: ["Loren Ipsum", "Loren Ipsum", "Loren Ipsum"]
    });

    CustomDatePicker.init('date-picker-start');
    CustomDatePicker.init('date-picker-end');

    Popovers.handlePopovers();

    $('#collection_name').focus();

    });
</script>
