#!/bin/bash
#small script to add the .bash_are submodul to .bashrc
#in futhure by updating the .bashrc has not to be changed
#author: Hanno Lemoine
###########################

echo "" >> /home/android/.bashrc
echo "#ARE Submodul (The Honeynet Project)" >> /home/android/.bashrc
echo "if [ -f ~/tools/.bash_are ]; then" >> /home/android/.bashrc
echo "     . ~/tools/.bash_are" >> /home/android/.bashrc
echo "fi" >> /home/android/.bashrc


