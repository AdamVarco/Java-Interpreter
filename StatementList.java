package interpreter;
import java.util.*;

public class StatementList {

   private ArrayList<Statement> statements;
		
		public StatementList ()
		{
			statements = new ArrayList<Statement>();
		}
		
		public void addStatement (Statement all)
		{
			statements.add(all);
		}
	
		
		public void execute()
		{
			Iterator<Statement> i = statements.iterator();
			while (i.hasNext())
				i.next().execute();
		}

		
	}

