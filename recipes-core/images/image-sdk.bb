DESCRIPTION = "A fully functional image to be placed on SD card"

ROOTFS_POSTPROCESS_COMMAND += "install_sketch ; "
IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL} packagegroup-core-basic packagegroup-core-lsb kernel-dev"

IMAGE_LINGUAS = " "

LICENSE = "GPLv2"

IMAGE_FSTYPES = "ext3 live"

inherit core-image

IMAGE_ROOTFS_SIZE = "2048"

#IMAGE_FSTYPES_remove = "cpio.lzma"
NOISO = "1"
NOHDD = "1"
IMAGE_ROOTFS_SIZE = "3072000"

EXTRA_IMAGECMD_append_ext2 = " -N 2000"

IMAGE_FEATURES += "package-management tools-sdk dev-pkgs tools-debug eclipse-debug tools-profile tools-testapps debug-tweaks"

#ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "

IMAGE_INSTALL += "kernel-modules"
IMAGE_INSTALL += "ethtool"
IMAGE_INSTALL += "strace"
IMAGE_INSTALL += "ppp"
IMAGE_INSTALL += "linuxptp"
IMAGE_INSTALL += "libstdc++"

IMAGE_INSTALL += "opencv"
IMAGE_INSTALL += "python python-modules python-numpy python-opencv"
IMAGE_INSTALL += "python python-opencv"
IMAGE_INSTALL += "alsa-lib alsa-utils alsa-tools"
IMAGE_INSTALL += "wireless-tools"
IMAGE_INSTALL += "wpa-supplicant"
IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "nodejs"

IMAGE_INSTALL += "linux-firmware-iwlwifi-6000g2a-6"
IMAGE_INSTALL += "linux-firmware-iwlwifi-135-6"
IMAGE_INSTALL += "bluez4"
IMAGE_INSTALL += "mosquitto galileo-target tor lighttpd ntp"

EXTRA_IMAGEDEPENDS = "grub-conf"

install_sketch() {
        install -d ${IMAGE_ROOTFS}/sketch
}

