import java.util.ArrayList;
import java.util.List;

public class exchange_cl {
private String x1;
private String x2;
private float rate_V;
private int x;
private float V3;
private float V4;
public List<String> cur_box1 = new ArrayList<String>();
public List<String> cur_box2 = new ArrayList<String>();
public List<Float> cur_rateV = new ArrayList<Float>();
public String getX1() {
	return x1;
}
public void setX1(String x1) {
	this.x1 = x1;
	cur_box1.add(x1);
}
public String getX2() {
	return x2;
}
public float getV3() {
	return V3;
}
public void setV3(float v3) {
	V3 = v3;
	
}
public float getV4() {
	return V4;
}
public void setV4(float v4) {
	V4 = v4;
}
public void setX2(String x2) {
	this.x2 = x2;
	cur_box2.add(x2);
}
public float getRate_V() {
	return rate_V;
}
public void setRate_V(float rate_V) {
	this.rate_V = rate_V;
	cur_rateV.add(rate_V);
}
public void setX(int x)
{
	this.x=x;
}
public int getX()
{
	return x;
}
@Override
public String toString() {
	if (x==1)return "1 " +x1+" = "+rate_V+" "+x2;
	else
		return V3 +x1+" = "+rate_V*V3+" "+x2 ;
	
}}
