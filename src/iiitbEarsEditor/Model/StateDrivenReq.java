/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Model;

/**
 *
 * @author Krish
 * Req Syntax : WHILE <in a specific state> the <system name> shall <system response>
 */
public class StateDrivenReq extends EARSRequirement{
    private String _reqSpecificState;
    private String _reqSysName;
    private String _reqSysResponse;
    
    public StateDrivenReq(){
    	super("State Driven");
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
