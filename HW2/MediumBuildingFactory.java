



public class MediumBuildingFactory extends BuildingFactory {

   public House getHouse(){
      return new MediumHouse();
   }

   public Condo getCondo(){
	  return new MediumCondo();
   }
   
   public SemiDetacher getSemiDetacher(){
	   return new MediumSemiDetacher();
   }
}
