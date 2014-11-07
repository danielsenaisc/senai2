package rightsize.industry

import control.BrandControl
import control.CategoryControl
import control.ModelingControl;
import domain.Modelagem;
import utils.OracleBoolean;

class ModelingController {
    
    ModelingControl modelagemControl = new ModelingControl();
    BrandControl marcaControl = new BrandControl();
    CategoryControl categoriaControl = new CategoryControl();
    
    def modelingList = new ArrayList();
    def brandList = new ArrayList();
    def categoryList = new ArrayList();

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() {  
    	modelingList = loadModels();
        [modelingList: modelingList]
    }

    def edit() {           
        Modelagem modeling = new Modelagem();     
        
        if(params.modelingId != null && params.modelingId.isBigDecimal()) modeling = modelagemControl.findById(params.modelingId.toBigDecimal());         
        
        modelingList = loadModels();
        brandList = loadBrand();
        categoryList = loadCategory();       
        
        return [modelingList: modelingList, modeling: modeling, brandList : brandList, categoryList: categoryList, gradeList:[]]
    }

    def loadModels(){
	return modelagemControl.selectAll();
    }
    
    def loadBrand(){
        return marcaControl.selectAll();
    }
    
    def loadCategory(){
        return categoriaControl.selectAll();
    }
    
    def saveModeling(){
        Modelagem novaModelagem = new Modelagem();
        if(params.modelingId != null && params.modelingId.isBigDecimal()) novaModelagem = modelagemControl.findById(params.modelingId.toBigDecimal());
        
        println(params);
        println(params.collectionOptionRadioGenre);
        println(params.modelingDescription);
        
//        novaModelagem.setNome(params.modelingName);
//        novaModelagem.setStatus(OracleBoolean.TRUE.getValue());
//        novaModelagem.setGenero(params.collectionOptionRadioGenre);
//        novaModelagem.setDescricao(params.modelingDescription);
//        novaModelagem.setIdInternoIndustria(params.modelingIndustryInternId);

        //try{
            //modelagemControl.add(novaModelagem);
        //}catch(NullPointerException ex){
            //TODO rotina de campos nulos
            //println("EXISTEM CAMPOS NAO POPULADOS CORRETAMENTE...");
        //}
        
        redirect(controller:"modeling", action:"index");
        }
}
