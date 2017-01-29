package interpreter;

public class Constant implements Operand
{

	private int value;

        public Constant(int value)
        {
         this.value = value;
        }

       @Override
       public int value()
       {
         return value;
       }

} 
