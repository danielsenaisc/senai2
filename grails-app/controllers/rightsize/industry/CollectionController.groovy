package rightsize.industry

import control.AttachmentCollectionControl
import control.BrandControl
import control.CategoryControl
import control.CollectionControl;
import control.CollectionStatusControl
import domain.Colecao;
import domain.ColecaoStatus

class CollectionController {
    CollectionControl colecaoControl = new CollectionControl();
    BrandControl marcaControl = new BrandControl();       
    CategoryControl categoryControl = new CategoryControl();
    CollectionStatusControl colecaoStatusControl = new CollectionStatusControl();
    AttachmentCollectionControl anexoColecaoControl = new AttachmentCollectionControl();

    def LOREN_IPSUM = "Lorem ipsum";

    def collectionList = new ArrayList();
    def statusList = new ArrayList<ColecaoStatus>();
    def userList = new ArrayList();
    def attachmentsList = new ArrayList();
    def brandList = new ArrayList();
	
    def index() {
    	collectionList = loadCollection();
        [collectionList: collectionList, innerCollectionControl: colecaoControl]
    }


    def edit() { 
        Colecao collection = new Colecao();      
        
        if(params.collectionId != null && params.collectionId.isBigDecimal()) collection = colecaoControl.findById(params.collectionId.toBigDecimal());
        
        statusList = loadStatus();
        userList = loadUser();
        attachmentsList = loadAttachments();
        brandList = loadBrands();     
        
        return [collection: collection, statusList: statusList, userList: userList, 
                attachmentsList: attachmentsList, brandList: brandList, innerCollectionControl: colecaoControl]
    }

    def create() { 
    	redirect(controller:"collection", action:"edit");
    }

    private

    def loadCollection(){
        if(colecaoControl.selectAll().size() <=0) return new ArrayList();
	return colecaoControl.selectAll();
    }

    def loadBrands(){        
        if(marcaControl.selectAll().size() <=0) return new ArrayList();
        return marcaControl.selectAll();
    }

    def loadStatus(){
        if(colecaoStatusControl.selectAll().size() <=0) return new ArrayList();
        return colecaoStatusControl.selectAll();             
    }

    def loadAttachments(){   
        if(anexoColecaoControl.selectAll().size() <=0) return new ArrayList();
        return anexoColecaoControl.selectAll();        
    }
    
    def loadUser(){
        
        userList = new ArrayList();
        userList.add("Janderson Araújo");
        userList.add("Juraci Riberio");
        userList.add("Claudinei da Silva");
        userList.add("Janderson Araújo");
        userList.add("Juraci Riberio");
        userList.add("Claudinei da Silva");
       
        return userList
    }
}
