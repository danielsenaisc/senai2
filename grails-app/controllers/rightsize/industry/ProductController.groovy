package rightsize.industry

import control.CollectionControl
import control.ProductControl;
import domain.Produtos

class ProductController {
    
    ProductControl produtoControl = new ProductControl();
    CollectionControl colecaoControl = new CollectionControl();
    
    def productList = new ArrayList();
    def gradeList = new ArrayList();
    def variantList = new ArrayList();
    def attrlist = new ArrayList();
    def collectionList = new ArrayList();

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() { 
    	productList = loadProduct();

        [productList: productList]
    }

    def edit() { 
        Produtos product = new Produtos();  
        
        if(params.productId != null && params.productId.isBigDecimal()) product = produtoControl.findById(params.productId.toBigDecimal());        
        
        collectionList = loadCollection();
        gradeList = loadGrade();
        variantList = loadVariant();
        productList = loadProduct();
        attrlist = loadAttribs();    
       

        return [collectionList: collectionList, product: product, gradeList: gradeList, variantList: variantList, 
        productList: productList, 
        attachmentList:[ "/css/global/plugins/jcrop/demos/demo_files/image1.jpg",
                        "/css/global/plugins/jcrop/demos/demo_files/image1.jpg"],
        attrlist: attrlist]
    }

     def create() { 
       redirect(controller:"product", action:"edit");
    }

    private loadProduct(){
        if(produtoControl.selectAll().size() <= 0) new ArrayList();
	return produtoControl.selectAll();
    }

    private loadGrade(){
        
        gradeList = new ArrayList();
        for ( i in 0..5 ) {
            gradeList.add(getRamdon());
        }
        return gradeList
    }

    private loadVariant(){

        variantList = new ArrayList();
        for ( i in 0..9 ) {
            variantList.add(getRamdon());
        }
        return variantList

    }

     private loadAttribs(){

        attrlist = new ArrayList();
        attrlist.add("Tipo de Lavagem");
        attrlist.add("Trama");
        attrlist.add("Pedrarias");
        attrlist.add("Bordado");
        attrlist.add("Tecnologias");
        attrlist.add("Nano Partículas");
        attrlist.add("Alergria");

        return attrlist

    }

    private getRamdon(){
        return Math.abs(new Random().nextInt() % 500 + 1)
    }
    
    private loadCollection(){
	if(colecaoControl.selectAll().size() <=0) new ArrayList();
        return colecaoControl.selectAll();
    }
}
