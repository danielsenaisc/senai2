package rightsize.industry

import control.ModelingControl;
import domain.Modelagem;

class ModelingController {
	
	ModelingControl modelagemControl = new ModelingControl();

    def modelList = new ArrayList();

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() { 
    	modelList = loadModels();

        [modelList: modelList]
    }

    def edit() { 
        [gradeList:[]]
    	
    }

    def create() { 
    	redirect(controller:"modeling", action:"edit");
    }

    def loadModels(){
		return modelagemControl.sellectAll();
    }
}
