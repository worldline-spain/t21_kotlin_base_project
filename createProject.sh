if [ $# -ne 3 ]
then
	echo "Please, enter the project and package name as parameter: createProject.sh PROJECT_NAME PACKAGE_DOMAIN.PACKAGE_NAME.PACKAGE_SUFIX OS_BASH: GIT, OSX"
else
	git clone https://vcs1.tempos21.com/scm/git/t21_kotlin_android_base_project &
	PID=$!
	wait $PID
	cd t21_kotlin_android_base_project
	path=`pwd`
	git checkout feature/architecture
	PID=$!
	wait $PID
	if [ $3 = "OSX" ]; then
		sh copy_osx_bash.sh $1 $2
	else
		sh copy_git_bash.sh $1 $2
	fi
	rm -rf $path
fi
