package rightsize.industry

import control.BrandControl
import control.ChannelControl
import domain.Marca

class BrandController {
	BrandControl marcaControl = new BrandControl();
	ChannelControl canalControl = new ChannelControl();
	
    ArrayList<Marca> brandList = new ArrayList<Marca>();
	
    def channelList = new ArrayList();
    def ageList = 4..80
    

    def LOREN_IPSUM = "Lorem ipsum"
	
    def index() { 
		brandList = loadBrand();

        [brandList: brandList]
    }

    def edit() { 
		if(params.brand != null) BigDecimal teste = params.brand.toBigDecimal();
		
		
    	channelList = loadChannels();

        [channelList: channelList, ageList: ageList] 
    }

    def create() {
		println(params.teste);
//		String nomeMarca = tablebody.gsp.campo1.gettext();
//		//
//		//
//		
//		
//		
//		
//		Marca m1 = new Marca();
//		m1.setNome(nomeMarca);
//		//
//		//
//		
//		marcaControl.add(m1);
		
    	//redirect(controller:"brand", action:"edit");
    }

    def loadBrand(){
    	return marcaControl.selectAll(); 
    }

     def loadChannels(){
		 //TODO fornecer os cansi referentes a marca
        return canalControl.selectAll();
    }
	 
    def merge(){
		println("Merjando");
	}
}
