#Hello Friends

echo 'File name is '$1

fileName=$1;

if [ -z "$fileName" ]; then
    fileName='file_inputs';
fi

java -jar ../target/parkingLot.jar $fileName

#javac ../src/com/parking/car/main/ParkingLot.java

#java com/parking/car/main/ParkingLot $fileName
