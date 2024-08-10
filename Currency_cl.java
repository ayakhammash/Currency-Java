import java.util.ArrayList;
import java.util.List;
    public class Currency_cl {
	private String symbol ;
	private String crName ;
	
	public List<String> cur_names = new ArrayList<String>();
	public List<String> cur_symbols = new ArrayList<String>();
	public String getSymbole() {
		return symbol;
	}
	public void setSymbole(String symbole) {
		this.symbol = symbole;
		cur_symbols.add(symbole.toUpperCase());
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
		cur_names.add(crName.toUpperCase());
	}
	@Override
	public String toString() {
		return    crName+"("+symbol+")"  ;
	}
	
}