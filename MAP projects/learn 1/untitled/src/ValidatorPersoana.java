public class ValidatorPersoana implements Validator<Persoana>{
    @Override
    public void validate(Persoana e) throws ValidationException{
        String errMsg = "";
        if(e.getNume() == null || "".equals(e.getNume()))
            errMsg += "!!!Nume invalid!!!\n";
        if(e.getVarsta() < 0)
            errMsg += "!!!Varsta invalida!!!\n";

        if(errMsg!=""){
            throw new ValidationException(errMsg);
        }
    }
}
