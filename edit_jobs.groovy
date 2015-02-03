// BE VERY CAREFUL!
// KEEP THE ACTUAL COMMAND COMMNETED OUT
// UNTIL YOU'RE 100% SURE IT WILL ONLY AFFECT THE JOBS YOU WANT

// For documentation see http://javadoc.jenkins-ci.org/hudson/model/Job.html

for(item in Hudson.instance.items)
{
  if (is_right_job(item.name)) {
    println("Working on project <$item.name>");
    println("\t assigned node is: "+item.assignedLabel);
    def lab = new hudson.model.labels.LabelAtom("put_name_of_node_here");

    println("\t Setting assignedLabel");
    //item.setAssignedLabel(lab); // uncomment this to make it work
    println("\t NEW assigned node is: "+item.assignedLabel);
    //item.delete(); println("\tDeleted job"); // Delete the job completely. Be Careful!!
  }
}

public boolean is_right_job(String s){
    return s.matches("regex_to_match_something_.*") && ! s.matches(".*_another_regex_here_.*") && ! s.matches(".*_third_regex_here_.*");
}
