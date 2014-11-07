<!DOCTYPE html>

<div class="portlet box blue-madison">
    <div class="portlet-title">
        <div class="caption">
            <g:message code="brand.form.edit.basic"/>

            <a href="javascript:;" class="popovers" data-container="body" data-trigger="hover" 
            data-content="<g:message code="popovers.title"/>" data-original-title="<g:message code="popovers.info"/>" data-placement="top">
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
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="brand.table.column.name"/></label>
                            <div class="col-md-3">
                                <div class="input-icon right">
                                    <input name="brandName" id="brand_name" type="text" class="form-control input-xlarge col-wid399" tabindex="1" value="${brand.getNome()}">
                                </div>
                            </div>

                        </div>
                        <!-- DESCRIPTION -->
                        <div class="form-group">
                            <label class="col-md-3 control-label"><g:message code="brand.form.edit.description"/></label>
                            <div class="col-md-3">
                                <div class="input-icon right">
                                    <textarea name="brandDescription" class="form-control input-xlarge col-wid399" rows="7" tabindex="2" maxlength="600">${brand.getDescricao()}</textarea>
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
                                                Selecione um arquivo 
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

<!-- DATA -->
                <div class="form-group">
                    <div class="col-md-4">
                        <label style = "text-align:right;" class="col-md-6 control-label">
                            <g:message code="brand.form.edit.dt_created"/>
                        </label>
                        <div  class="col-md-4 col-wd148">
                            <input name="brandCreationDate" id="date-picker" class="form-control form-control-inline input-small date-picker" size="16" type="text" value="${brand.getDataCriacaoTratada()}" tabindex="3" /></i>
                        </div>
                    </div>
                    <!-- COUNTRY -->
                    <div class="col-md-4">
                        <label class="control-label col-md-2"><g:message code="brand.form.edit.country"/></label>
                        <div class="col-md-8" style="margin-right: 10px; margin-left: 12px;">
                            <div class="form-group">
                                <g:select name="countryListComboBox" from="${countryList}" value="${brand.getDefaultCountry()}" class="form-control input-small col-wd148" tabindex="4"/>
                            </div>
                        </div>
                    </div>	
                </div>

                                <!-- ACTIVE -->
                <div class="form-group">
                    <div class="col-md-2">
                    </div>
                    <div  class="col-md-4">
                        <label class="radio-inline">
                            <input type="radio" name="isBrandActive" id="optionsRadios4" value="Y" tabindex="5" ${brand.isActive()} > Ativa </label>
                        <label class="radio-inline">
                            <input type="radio" name="isBrandActive" id="optionsRadios5" value="N" tabindex="6" ${brand.isInactive()} > Inativa </label>
                    </div>
                </div>

            </div>

        </div>
    </div>


</div>

<script>
    jQuery(document).ready(function() {   

    CustomDatePicker.init('date-picker');

    Popovers.handlePopovers();

    $('#brand_name').focus();

    });
</script>