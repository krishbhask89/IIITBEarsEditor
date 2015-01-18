/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitb.EarsEditor.Model;

/**
 *
 * @author Krish
 * Req Syntax : WHILE <in a specific state> the <system name> shall <system response>
 */
public class StateDrivenReq extends EARSRequirement{
    private String _reqSpecificState;
    private String _reqSysName;
    private String _reqSysResponse;
    
    public StateDrivenReq(String _reqId){
    	super("State Driven", _reqId);
    }
    
    public StateDrivenReq(String specState,String sName, String sResp,String rCCode, String _reqId){
        super("State Driven",rCCode,_reqId);
        this._reqSpecificState = specState;
        this._reqSysName = sName;
        this._reqSysResponse = sResp;
    }
    public String getReqSpecificState() {
        return _reqSpecificState;
    }

    public String getReqSysName() {
        return _reqSysName;
    }

    public String getReqSysResponse() {
        return _reqSysResponse;
    }

    public void setReqSpecificState(String _reqSpecificState) {
        this._reqSpecificState = _reqSpecificState;
    }

    public void setReqSysName(String _reqSysName) {
        this._reqSysName = _reqSysName;
    }

    public void setReqSysResponse(String _reqSysResponse) {
        this._reqSysResponse = _reqSysResponse;
    }
}
