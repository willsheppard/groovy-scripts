// HOW TO PROGRAMATICALLY START A SET OF JENKINS JOBS

// Run at http://hostname-of-jenkins/script/

// BE VERY CAREFUL!
// KEEP THE ACTUAL COMMAND COMMNETED OUT
// UNTIL YOU'RE 100% SURE IT WILL ONLY AFFECT THE JOBS YOU WANT

// For documentation see http://javadoc.jenkins-ci.org/hudson/model/Job.html

for(item in Hudson.instance.items) {

    if (is_right_job(item.name)) {

        println("Working on project <$item.name>");

        def buildNumber = item.getNextBuildNumber()
        println("next build number = $buildNumber")

        // Start the build job
        boolean targetBuildQueued = item.scheduleBuild(
            new Cause.UserCause()
        );

        if (targetBuildQueued) {
            println("Build started successfully")
            //println("Console (wait a few seconds before clicking): $jobUrl/$buildNumber/console")
        } else {
            println("Could not start target build job")
        }

    } // if is_right_job

} // foreach item

public boolean is_right_job(String s){
    return s.matches("regex_to_match_jenkins_jobs_.*");
}

