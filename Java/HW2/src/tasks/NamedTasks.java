package tasks;

public class NamedTasks extends Tasks {
	// class that represented named tasks
	private String[] names;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}

	public boolean dependsOn(String task1, String task2) {
		// index of the string in the list of names list is the task number
		int task1Index = -1, task2Index = -1, i = 0;
		for (String name : names) {
			if (name.equals(task1))
				task1Index = i;
			else if (name.equals(task2))
				task2Index = i;
			i++;
		}
		return super.dependsOn(task1Index, task2Index);
	}

	public String[] nameOrder() {
		// index of the string in the list of names list is the task number 
		String[] ret = new String[names.length];
		int[] supRet = super.order();
		if (supRet == null)
			return null;
		for (int i = 0; i < supRet.length; i++) {
			ret[i] = names[supRet[i]];
		}
		return ret;
	}
}
