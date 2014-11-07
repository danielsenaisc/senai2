package rightsize.industry

import control.BrandControl
import control.CategoryControl
import control.ModelingControl;
import domain.Modelagem;

class ModelingController {
	
    ModelingControl modelagemControl = new ModelingControl();
    BrandControl marcaControl = new BrandControl();
    CategoryControl categoriaControl = new CategoryControl();
    
    def modelList = new ArrayList();
    def brandList = new ArrayList();
    def categoryList = new ArrayList();

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() {  
        
    	modelList = loadModels();

        [modelList: modelList]
    }

    def edit() {           
        Modelagem modeling = new Modelagem();     
        
        if(params.modelingId != null && params.modelingId.isBigDecimal()) modeling = modelagemControl.findById(params.modelingId.toBigDecimal());         
        modelList = loadModels();
        brandList = loadBrand();
        categoryList = loadCategory();       
        
        
        return [modelList: modelList, modeling: modeling, brandList : brandList, categoryList: categoryList, gradeList:[]]
    	
    }

    def create() { 
    	redirect(controller:"modeling", action:"edit");
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
}
