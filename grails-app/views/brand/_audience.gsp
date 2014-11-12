<!DOCTYPE html>
<!-- AUDIENCE -->
<div class="portlet box blue-madison">
    <div class="portlet-title">
        <div class="caption">
            <g:message code="brand.form.edit.audience"/>
            <a href="javascript:;" class="popovers" data-container="body" data-trigger="hover" 
            data-content="<g:message code="popovers.title"/>" data-original-title="<g:message code="popovers.info"/>" data-placement="top">
            <i class="fa fa-info-circle popovers" ></i> 
            </a>
        </div>

    </div>

    <div class="portlet-body form">
        <div role="form" class="form-horizontal">
            <div class="form-body">
                    <!-- LOCATION -->
                <div class="form-group">
                    <div class="col-md-4">
                        <label class="control-label col-md-6"><g:message code="brand.form.edit.audiente.location"/></label>
                        <div class="col-md-2" tabindex="7">
                            <input name="brandAudienceLocalization" id="location_tag" type="text" class="form-control tags medium" value="${innerBrandControl.getLocationsListTratado(brand)}"/>
                        </div>
                    </div>
                </div>
                <!-- AGE -->
                <div class="form-group">
                    <div class="col-md-4">
                        <label class="col-md-6 control-label"><g:message code="brand.form.edit.audiente.ages"/></label>
                        <div class="col-md-1" style="margin-left: 30px;">
                            <div class="form-group">
                                <div class="form-group">
                                    <g:select name="brandInitialAge" from="${ageList}" value="${brand.getIdadeInicial()}" 
                                        class="form-control input-small age-select" tabindex="8"/>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-1" >
                            <i class="fa fa-chevron-right" style="padding-top:16px;"></i>
                        </div>

                        <div class="col-md-1" style="margin-left: 20px;">
                            <div class="form-group">
                                <div class="form-group">
                                    <g:select name="brandFinalAge" from="${ageList}" value="${brand.getIdadeFinal()}" 
                                        class="form-control input-small age-select" tabindex="9"/>
                                </div>
                            </div>
                        </div>
                    </div>	
                </div>	

                                <!-- GENRE -->
                <div class="form-group">
                    <label class="col-md-2 control-label"><g:message code="product.table.column.gender"/></label>
                    <div class="col-md-6 radio-list">
                        <label class="radio-inline">
                            <input type="radio" name="brandOptionRadioGenre" id="optionsRadios4" value="M" tabindex="10" ${innerBrandControl.isMascChecked(brand)} > Masc. </label>
                        <label class="radio-inline">
                            <input type="radio" name="brandOptionRadioGenre" id="optionsRadios5" value="F" tabindex="11" ${innerBrandControl.isFemChecked(brand)} > Fem. </label>
                        <label class="radio-inline">
                            <input type="radio" name="brandOptionRadioGenre" id="optionsRadios6" value="U" tabindex="12" ${innerBrandControl.isUnissexChecked(brand)} > Unissex </label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label class="control-label col-md-6"><g:message code="brand.form.edit.audiente.styles"/></label>
                            <div class="col-md-6" tabindex="13">
                                <input name="brandAudienceStyles" id="style_tag" type="text" class="form-control tags medium" value="${innerBrandControl.getEstiloListTratado(brand)}"/>
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

    $("#location_tag").select2({
    width: 300,
    'defaultText':'nova tag...',
    tags: ["Loren Ipsum", "Loren Ipsum", "Loren Ipsum"]
    });

    $("#style_tag").select2({
    width: 300,
    'defaultText':'nova tag...',
    tags: ["Loren Ipsum", "Loren Ipsum", "Loren Ipsum"]
    });

    });
</script>