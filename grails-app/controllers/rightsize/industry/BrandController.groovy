package rightsize.industry

import control.AbrangenceControl
import control.BrandControl
import control.ChannelControl
import control.CountryControl
import control.IndustryControl
import domain.Canal
import domain.Estilo
import domain.Industria
import domain.Marca
import utils.Formatter;

class BrandController {
    Industria industriaAtual;
    int idIndustria = 100;
    
    IndustryControl industryControl = new IndustryControl();
    BrandControl marcaControl = new BrandControl();
    ChannelControl canalControl = new ChannelControl();
    CountryControl paisControl = new CountryControl();
    AbrangenceControl abrangenciaControl = new AbrangenceControl();
		
    def brandList;
    def brandChannelList;
    def channelList;
    def audienceList;
    def countryList;
    
    def ageList = 0..99
	
    def index() { 
	brandList = loadBrand();
        [brandList: brandList]
    }

    def edit() { 
        Marca brand = new Marca();
        
        if(params.brandId != null && params.brandId.isLong()) brand = marcaControl.findById(params.brandId.toLong());  
        
        brandChannelList = loadBrandChannels(brand);
        channelList = loadChannels();
        audienceList = loadAudienceList();
        countryList = loadCountrys();
                
        return [brand: brand , brandChannelList: brandChannelList, 
            ageList: ageList, audienceList: audienceList, channelList: channelList,
            countryList: countryList]
    }

    def loadBrand(){
        if(marcaControl.selectAll().size() <=0) return new ArrayList();
    	return marcaControl.selectAll();
    }

    def loadBrandChannels(Marca brand){
        if(brand.getId() == null) return new ArrayList<Canal>();
        return brand.getMarcaCanalList();
    }
	 
    def loadCountrys(){
        if(paisControl.selectAll().size() <=0) return new ArrayList();
        return paisControl.selectAll();
    }
    
    def loadChannels(){
        if(canalControl.selectAll().size() <=0) return new ArrayList();
        return canalControl.selectAll();
    }
    
    def loadAudienceList(){
        if(abrangenciaControl.selectAll().size() <= 0) return new ArrayList();
        return abrangenciaControl.selectAll(); 
    }
    
    private def isSelected(Long matchItem, Long listItem){
        if(matchItem == listItem) return "checked"
        return "";
    }
    
    def saveBrand(){
        Marca novaMarca = new Marca();
        
        if(params.brandId != null && params.brandId.isLong()) novaMarca = marcaControl.findById(params.brandId.toLong());
        
        //TODO novaMarca.setImage()
        //TODO novaMarca.novoPais();
        
        novaMarca.setNome(params.brandName);
        novaMarca.setDescricao(params.brandDescription);
        novaMarca.setDataCriacao(Formatter.stringToDate(params.brandCreationDate));
        novaMarca.setStatus(params.isBrandActive.toCharacter());

        //TODO channels table
        //criaCanaisAssociadosAMarca(/* params allChannels  */);
        
        //TODO estrategia correta para adicionar localizacoes
        //        println(params.brandAudienceLocalization);
        
        novaMarca.setIdadeInicial(params.brandInitialAge.toLong());
        novaMarca.setIdadeFinal(params.brandFinalAge.toLong());
        novaMarca.setGenero(params.brandOptionRadioGenre.toCharacter());
        
        //TODO Elaborar estrategia correta para adicionar estilos
        //        println(params.brandAudienceStyles)

        industriaAtual = industryControl.findById(new BigDecimal(idIndustria));
        
        novaMarca.setIndustriaId(industriaAtual);
        
        try{
            marcaControl.add(novaMarca);
        }catch(NullPointerException ex){
            //TODO rotina de campos nulos
            println("EXISTEM CAMPOS NAO POPULADOS CORRETAMENTE...");
        }

        println(novaMarca.getId());
        
        redirect(controller:"brand", action:"index");
    }
}
