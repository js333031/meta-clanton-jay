ssh-keygen -q -f ssh_host_rsa_key -N '' -t rsa
ssh-keygen -q -f ssh_host_ecdsa_key -N '' -t ecdsa
ssh-keygen -q -f ssh_host_dsa_key -N '' -t dsa
tar cf sshd-keys.tar ssh_host*
rm ssh_host_rsa_key*
rm ssh_host_ecdsa_key*
rm ssh_host_dsa_key*

