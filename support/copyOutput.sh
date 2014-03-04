#!/bin/sh
BUILD_OUT_DIR=`pwd`/tmp/deploy/images
DST_DIR=''
if [ -n "$1" ]; then
   echo "destination is $1"
   DST_DIR="$1"
else
   echo "arg 1 is blank - please specify destination path"
   exit 1
fi

if [ -n "$2" ]; then
   echo "arg 2 is $2 "
   IMG_TYPE="$2"
else
   echo "arg 2 is blank. Assuming full, image type can be medium or full)"
fi

makecopy () 
{
	cp -r $BUILD_OUT_DIR/boot $DST_DIR
		cp $BUILD_OUT_DIR/bzImage $DST_DIR
		cp $BUILD_OUT_DIR/core-image-minimal-initramfs-clanton.cpio.gz $DST_DIR
		cp $BUILD_OUT_DIR/grub.efi $DST_DIR

	case "$IMG_TYPE" in
		medium)
			cp $BUILD_OUT_DIR/image-medium-clanton.ext3 $DST_DIR/image-full-clanton.ext3
			;;
		full)
			cp $BUILD_OUT_DIR/image-full-clanton.ext3 $DST_DIR/image-full-clanton.ext3 
			;;
		*)
			cp $BUILD_OUT_DIR/image-full-clanton.ext3 $DST_DIR/image-full-clanton.ext3
			;;
		esac
}

makecopy

