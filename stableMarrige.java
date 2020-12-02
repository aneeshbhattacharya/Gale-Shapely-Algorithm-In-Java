import java.util.*;
import java.io.*;
import java.lang.*;

class Man{

	public Woman engagedTo;
	public String name;
	public LinkedList<String> preferences;
	public LinkedList<String> proposals;
	public int rankOfPairedWith;

	Man(){
		engagedTo=null;
		name="";
		preferences = new LinkedList<String>();
		proposals = new LinkedList<String>();
		rankOfPairedWith=100;
	}

	public void setName(String n){
		name = n;
	}

	public void setPreferences(String a,String b,String c,String d){
		preferences.add(a);
		preferences.add(b);
		preferences.add(c);
		preferences.add(d);
	}

	public void setProposals(String s){
		proposals.add(s);
	}

	public void clearProposals(){
		proposals.clear();
	}

	public void setEngagedTo(Woman t){
		engagedTo=t;
	}

	public Woman getEngagedTo(){
		return engagedTo;
	}
	public LinkedList<String> getPreferences(){
		return preferences;
	}
	public LinkedList<String> getProposals(){
		return proposals;
	}
	public void setRankOfPairedWith(int x){
		rankOfPairedWith=x;
	}
	public int getRankOfPairedWith(){
		return rankOfPairedWith;
	}

	public String getName(){
		return name;
	}
}

class Woman{

	public String name;
	public LinkedList<String> preferences;
	public boolean rejected;
	public boolean engaged;
	public int attemptNumber;

	Woman(){
		name="";
		preferences = new LinkedList<String>();
		rejected=true;
		attemptNumber=0;
		engaged=false;
	}

	public void setName(String n){
		name=n;

	}
	public void setPreferences(String a,String b,String c,String d){
		preferences.add(a);
		preferences.add(b);
		preferences.add(c);
		preferences.add(d);
	}
	public void setRejected(boolean x){
		rejected=x;
	}
	public void setEngaged(boolean x){
		engaged=x;
	}
	public void setAttemptNumber(int x){
		attemptNumber=x;
	}

	public String getName(){
		return name;
	}
	public LinkedList<String> getPreferences(){
		return preferences;
	}
	public boolean getRejectedStatus(){
		return rejected;
	}
	public boolean getEngagedStatus(){
		return engaged;
	}
	public int getAttemptNumber(){
		return attemptNumber;
	}
}

class AlgorithmClass{

	public LinkedList<Man> men;
	public LinkedList<Woman> women;
	public boolean allEngaged;

	public int indexOfWoman;

	AlgorithmClass(){
		men = new LinkedList<Man>();
		women = new LinkedList<Woman>();
		allEngaged=true;
	
		indexOfWoman=-1;
	}

	public void addMan(Man a,Man b,Man c,Man d){
		men.add(a);
		men.add(b);
		men.add(c);
		men.add(d);
	}
	public void addWoman(Woman a,Woman b, Woman c,Woman d){
		women.add(a);
		women.add(b);
		women.add(c);
		women.add(d);
	}
	public LinkedList<Woman> getWomen(){
		return women;
	}
	public LinkedList<Man> getMen(){
		return men;
	}

	public void theAlgorithm(int iterations){

		for(int k=0;k<iterations;k++){

		for(int i=0;i<women.size();i++){

			Woman w = women.get(i);
			
			if(w.getRejectedStatus()!=false){

				LinkedList<String> preferences = w.getPreferences();

				if(w.getAttemptNumber()<men.size()){

						String s = preferences.get(w.getAttemptNumber());
						w.setAttemptNumber(w.getAttemptNumber()+1);

					for(int j=0;j<=men.size();j++){

						Man m = men.get(j);

						if(m.getName().equals(s)==true){
						
							m.setProposals(w.getName());
							break;
						}
						else{
							continue;
						}
					}
				}
			}
			else{
				continue;
			}
		}

		for(int i=0;i<men.size();i++){
			Man m = men.get(i);

			LinkedList<String> preferences = m.getPreferences();
			LinkedList<String> proposals= m.getProposals();

				
				for(int j=0;j<preferences.size();j++){

					if(proposals.contains(preferences.get(j))==true){


						for(int z=0;z<women.size();z++){
							Woman w = women.get(z);
							if(w.getName().equals(preferences.get(j))==true){
							
								indexOfWoman = women.indexOf(w);

								break;
							}
							else{
								continue;
							}
						}

						Woman w = women.get(indexOfWoman);
						indexOfWoman=-1;

						if(w.getEngagedStatus()==false){

							if(m.getEngagedTo()==null){

								m.setEngagedTo(w);
								w.setRejected(false);
								w.setEngaged(true);
								m.setRankOfPairedWith(j);
								break;
							}

							else{

								if(j<m.getRankOfPairedWith()){
									Woman x = m.getEngagedTo();
									x.setRejected(true);
									x.setEngaged(false);
									m.setEngagedTo(w);
									w.setRejected(false);
									w.setEngaged(true);
									m.setRankOfPairedWith(j);
									break;
								}
								else{
									break;
								}

							}
						}
						else{
							continue;
						}
					}
					else{
						continue;
					}
				}
		
		}

		for(int i=0;i<men.size();i++){
			Man m = men.get(i);
			m.clearProposals();
		}

		for(int i=0;i<women.size();i++){
			Woman w = women.get(i);
			if(w.getEngagedStatus()!=true){	
				allEngaged=false;			
			}
			else{
				continue;
			}
		}

		if(allEngaged==true){
			System.out.println("Algorithm concluded");
			
			
		}
		else{

			
			continue;
		}
	}
	}

}












class stableMarrige{
	
	public static void main(String[] args) {
		
		Man bingley = new Man();
		Man collins = new Man();
		Man darcy = new Man();
		Man wickhem = new Man();

		Woman charolette = new Woman();
		Woman elizabeth = new Woman();
		Woman jane = new Woman();
		Woman lydia = new Woman();

		AlgorithmClass algo = new AlgorithmClass();

		bingley.setName("Bingley");
		collins.setName("Collins");
		darcy.setName("Darcy");
		wickhem.setName("Wickhem");

		charolette.setName("Charolette");
		elizabeth.setName("Elizabeth");
		jane.setName("Jane");
		lydia.setName("Lydia");

		bingley.setPreferences("Jane", "Elizabeth","Lydia","Charolette");
		collins.setPreferences("Jane","Elizabeth","Lydia","Charolette");
		darcy.setPreferences("Elizabeth","Jane","Charolette","Lydia");
		wickhem.setPreferences("Lydia","Jane","Elizabeth","Charolette");

		charolette.setPreferences("Bingley","Darcy","Collins","Wickhem");
		elizabeth.setPreferences("Wickhem","Darcy","Bingley","Collins");
		jane.setPreferences("Bingley","Wickhem","Darcy","Collins");
		lydia.setPreferences("Bingley","Wickhem","Darcy","Collins");

		algo.addMan(bingley,collins,darcy,wickhem);
		algo.addWoman(charolette,elizabeth,jane,lydia);

		System.out.println("State number of iterations");
		Scanner sc= new Scanner(System.in);
		int iterations = sc.nextInt();


		try{



		algo.theAlgorithm(iterations);		

		System.out.println("Bingley is paired with "+bingley.getEngagedTo().getName());
		System.out.println("Wickhem is paired with "+wickhem.getEngagedTo().getName());
		System.out.println("Darcy is paried with "+darcy.getEngagedTo().getName());
		System.out.println("Collins is paired with "+collins.getEngagedTo().getName());}
		catch(Exception e){
			return;
		}

	}
}