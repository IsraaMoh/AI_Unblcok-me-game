/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;
import java.util.ArrayList;
import java.util.List;

public class node implements Comparable<node>{
  public List<par> state;
  public int ES;
  public int depth;
  node(List<par> s, int e, int d){
	  state=new ArrayList<>(s); state.clear();
	  listcopy(state,s);
	  ES=e;
	  depth=d;
  }
  public void listcopy(List<par> dest,List<par> src){
		for(par c: src)
			dest.add(new par(c.id,c.row,c.col,c.len,c.Ori));
  }
  public int compareTo(node x) {   //min heap
      return this.ES < x.ES ? -1 : 1;  
  }  
}