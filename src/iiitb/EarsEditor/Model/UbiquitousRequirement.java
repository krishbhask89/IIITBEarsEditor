/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitb.EarsEditor.Model;

/**
 *
 * @author Krish
 * Req Syntax : The <system name> shall <system response>
 */
public class UbiquitousRequirement extends EARSRequirement{
    private String _reqSysName;
    private String _reqSysResponse;

    public void setReqSysName(String _reqSysName) {
        this._reqSysName = _reqSysName;
    }

    public void setReqSysResponse(String _reqSysResponse) {
        this._reqSysResponse = _reqSysResponse;
    }

    public String getReqSysName() {
        return _reqSysName;
    }

    public String getReqSysResponse() {
        return _reqSysResponse;
    }
    
    public UbiquitousRequirement(){
    	super("Ubiquitous");
    }
    
    public UbiquitousRequirement(String sName, String sResp,String reqCCode, String reqIndex){
        super("Ubiquitous",reqCCode,reqIndex);
        this._reqSysName = sName;
        this._reqSysResponse = sResp;
    }
}
