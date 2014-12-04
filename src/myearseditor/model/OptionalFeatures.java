/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myearseditor.model;

/**
 *
 * @author Krish
 * Req Syntax : WHERE <feature is included> the <system name> shall <system response>
 */
public class OptionalFeatures extends EARSRequirement{
    private String _reqFeatureIncluded;
    private String _reqSysName;
    private String _reqSysResponse;

    public OptionalFeatures(){
    	super("Optional Features");
    }
    
    public OptionalFeatures(String featIncl,String sName, String sResp,String rCCode, String rIndex){
        super("Optional Features",rCCode,rIndex);
        this._reqFeatureIncluded = featIncl;
        this._reqSysName = sName;
        this._reqSysResponse = sResp;
    }
    
    public String getReqFeatureIncluded() {
        return _reqFeatureIncluded;
    }

    public String getReqSysName() {
        return _reqSysName;
    }

    public String getReqSysResponse() {
        return _reqSysResponse;
    }

    public void setReqFeatureIncluded(String _reqFeatureIncluded) {
        this._reqFeatureIncluded = _reqFeatureIncluded;
    }

    public void setReqSysName(String _reqSysName) {
        this._reqSysName = _reqSysName;
    }

    public void setReqSysResponse(String _reqSysResponse) {
        this._reqSysResponse = _reqSysResponse;
    }
    
    
}
