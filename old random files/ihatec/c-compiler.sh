#! /bin/zsh
echo "What file do you wish to compile & run?"
echo "Please put in the file location"
read filelocation
echo "What do you wish for the file to be called?"
read filename
cc $filelocation -o $filename
./$filename
