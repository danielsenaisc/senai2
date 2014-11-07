package rightsize.industry

import utils.OracleBoolean
import control.BrandControl
import control.CollectionControl
import control.ModelingControl
import control.ProductControl

class DashboardController {

    ProductControl produtoControl = new ProductControl();
    CollectionControl colecaoControl = new CollectionControl();
    BrandControl marcaControl = new BrandControl();
    ModelingControl modelagemControl = new ModelingControl();
	
	
    def productRankingList = new ArrayList();
    def bestCollectionsList = new ArrayList();
    def alertList = new ArrayList();

    def brandCount = new Integer(0);
    def activeProductCount = new Integer(0);
    def inactiveProductCount = new Integer(0);
    def activeCollectionCount = new Integer(0);
    def inactiveCollectionCount = new Integer(0);
    def activeModelCount = new Integer(0);
    def inactiveModelCount = new Integer(0);

    def LOREN_IPSUM = "Lorem ipsum"

    def index() { 

    	productRankingList = loadProductRanking();
    	bestCollectionsList = loadBestCollections();
        alertList = loadAlertList();

    	brandCount = getBrandCount();

    	activeProductCount = getActiveProductCount();
    	inactiveProductCount = getInactiveProductCount();

    	activeCollectionCount = getActiveCollectionCount();
    	inactiveCollectionCount = getInactiveCollectionCount();

    	activeModelCount = getActiveModelCount();
    	inactiveModelCount = getInactiveModelCount();

    	[productRankingList: productRankingList, 
            bestCollectionsList: bestCollectionsList,
            alertList: alertList,
            brandCount: brandCount,
            activeModelCount: activeModelCount,
            inactiveModelCount: inactiveModelCount,
            activeCollectionCount: activeCollectionCount,
            inactiveCollectionCount: inactiveCollectionCount,
            activeProductCount: activeProductCount,
            inactiveProductCount: inactiveProductCount
        ]

    }

    private

    def loadProductRanking(){
    	return produtoControl.getBestProducts();
    }

    def loadBestCollections(){
        return colecaoControl.getBestColections();
    }

    def loadAlertList(){

        alertList = new ArrayList();
        for ( i in 0..3 ) {
            alertList.add(LOREN_IPSUM + " " + i);
        }
        return alertList
    }

    def getBrandCount(){
    	return marcaControl.selectAll().size();
    }

    def getActiveProductCount(){
    	return produtoControl.findByStatus(OracleBoolean.TRUE).size();
    }

    def getInactiveProductCount(){
    	return produtoControl.findByStatus(OracleBoolean.FALSE).size();
    }

    def getActiveCollectionCount(){
    	return colecaoControl.findByStatus("Ativo").size();
    }
    
    def getInactiveCollectionCount(){
    	return colecaoControl.findByStatus("Inativo").size();
    }

    def getActiveModelCount(){
    	return modelagemControl.findByStatus(OracleBoolean.TRUE).size();
    }
    
    def getInactiveModelCount(){
    	return modelagemControl.findByStatus(OracleBoolean.FALSE).size();
    }

}
