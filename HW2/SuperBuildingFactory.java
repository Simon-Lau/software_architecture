





public class SuperBuildingFactory extends BuildingFactory {

   public House getHouse(){
      return new SuperHouse();
   }

   public Condo getCondo(){
	  return new SuperCondo();
   }
   
   public SemiDetacher getSemiDetacher(){
	   return new SuperSemiDetacher();
   }
}
