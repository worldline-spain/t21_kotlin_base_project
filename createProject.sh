if [ $# -ne 2 ]
then
	echo "Please, enter the project and package name as parameter: createProject.sh PROJECT_NAME PACKAGE_DOMAIN.PACKAGE_NAME.PACKAGE_SUFIX"
else
	git clone https://vcs1.tempos21.com/scm/git/t21_kotlin_android_base_project &
	PID=$!
	wait $PID
	cd t21_kotlin_android_base_project
	path=`pwd`
	git checkout feature/architecture
	PID=$!
	wait $PID
	sh copy.sh $1 $2
	rm -rf $path
fi
