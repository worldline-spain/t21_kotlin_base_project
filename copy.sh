rename(){
	mv com $packageDomain
	cd $packageDomain
	mv worldline $packageDomainName
	cd $packageDomainName
	mv t21kotlinbaseproject $packageAppSufix
}	


if [ $# -ne 2 ]
then
	echo "Please, enter the project and package name as parameter: copy.sh PROJECT_NAME PACKAGE_DOMAIN.PACKAGE_NAME.PACKAGE_SUFIX"
else
	name=$1
	packageDomain="$(cut -d'.' -f1 <<<"$2")"
	packageDomainName="$(cut -d'.' -f2 <<<"$2")"
 	packageAppSufix="$(cut -d'.' -f3 <<<"$2")"

	echo "name $name"
	echo "Package $packageDomain.$packageDomainName.$packageAppSufix"

	mkdir ../$name
	cp -r * ../$name
	cd ../$name

	path=`pwd`
	
	rm copy.sh
	rm -rf build/

	# Presentation layer
	cd app
	rm -rf build

	cd "$path/app/src/androidTest/java"
	rename
	cd $path
	pwd
	cd app/src/main/java/
	rename
	cd $path
	pwd
	cd app/src/test/java
	rename
	cd $path
	pwd

fi

