/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Model;

/**
 *
 * @author Krish
 * Req Syntax : IF <optional preconditions> <trigger>, THEN the <system name> shall <system response>
 */
public class UnwantedBehaviour extends EARSRequirement{
    private String _reqOptionalPreCond;
    private String _reqTrigger;
    private String _reqSysName;
    private String _reqSysResponse;
    
    public UnwantedBehaviour(){
    	super("Unwanted Behaviour");
    }
    
    public void setReqOptionalPreCond(String _reqOptionalPreCond) {
        this._reqOptionalPreCond = _reqOptionalPreCond;
    }

    public void setReqTrigger(String _reqTrigger) {
        this._reqTrigger = _reqTrigger;
    }

    public void setReqSysName(String _reqSysName) {
        this._reqSysName = _reqSysName;
    }

    public void setReqSysResponse(String _reqSysResponse) {
        this._reqSysResponse = _reqSysResponse;
    }

    public String getReqOptionalPreCond() {
        return _reqOptionalPreCond;
    }

    public String getReqTrigger() {
        return _reqTrigger;
    }

    public String getReqSysName() {
        return _reqSysName;
    }

    public String getReqSysResponse() {
        return _reqSysResponse;
    }

}
