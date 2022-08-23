import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {
	 private Map<String, List<String>> tree;
	    private Set<String> deathNames;
	    
	    private String kingName;
		 
		   public ThroneInheritance( String kingName) {
	        tree = new HashMap();
	        deathNames = new HashSet();
	        this.kingName = kingName;
	    }

		    public void birth( String parentName, String childName) {
		    	
		    		if (!tree.containsKey(parentName)) {
		    			tree.put(parentName, new ArrayList<String>());
		    			}
		    				tree.get(parentName).add(childName);
		    				System.out.println(getInheritanceOrder().toString());
		    		}

		   public void death(String name) {
			   
	         deathNames.add(name);
	           System.out.println(getInheritanceOrder().toString());
	        
	    }
	    
	    public List<String> getInheritanceOrder() {
	        List<String>  curOrder = new ArrayList();
	        Successor(kingName, curOrder);
	        return  curOrder;
	    }
		   

	private void Successor(String parentName, List<String> curOrder) {
	        if (!deathNames.contains(parentName)) {
	            curOrder.add(parentName);
	        	}
	        if (tree.containsKey(parentName)) {
	            List<String> childs = tree.get(parentName);
	            for (String child : childs) {
	            	Successor(child ,curOrder);
	            	}    
	            }

	}
}
