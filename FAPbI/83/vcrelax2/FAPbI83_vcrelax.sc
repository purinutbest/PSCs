#### PBS Part ####
#PBS -N FAPbI83_vcrelax             
#PBS -S /bin/bash 
#PBS -l nodes=1:ppn=32
#PBS -q short
##### End Part ####

LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/data/users/c295129/LIB
export LD_LIBRARY_PATH
export MPI_EXE=/data/programs/openmpi-4.0.0/bin
export PWSCF_EXE=/data/users/c295129/bin
cd ~/FAPbI/83/vcrelax2      

cat $PBS_NODEFILE > node_list_FA83_vc.txt

$MPI_EXE/mpirun  -np 32 -machinefile node_list_FA83_vc.txt $PWSCF_EXE/pw.x <FAPbI83_vcrelax.in> FAPbI83_vcrelax.out 
