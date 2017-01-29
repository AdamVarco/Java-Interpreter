package interpreter;



public class PrintStatement implements Statement
{
 
   private ID variable;

   public PrintStatement(ID variable)
   {
     this.variable = variable;
    }
   
   @Override
   public void execute()
   {
    System.out.println(variable.value());
   }
}
