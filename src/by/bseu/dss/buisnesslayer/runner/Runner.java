package by.bseu.dss.buisnesslayer.runner;

import by.bseu.dss.buisnesslayer.alternatives.Office1;
import by.bseu.dss.buisnesslayer.alternatives.Office2;
import by.bseu.dss.buisnesslayer.alternatives.Office3;
import by.bseu.dss.buisnesslayer.criterias.building.Building;
import by.bseu.dss.buisnesslayer.criterias.building.subcriterias.BuildingType;
import by.bseu.dss.buisnesslayer.criterias.building.subcriterias.FloorNumber;
import by.bseu.dss.buisnesslayer.criterias.building.subcriterias.OutsideAppearance;
import by.bseu.dss.buisnesslayer.criterias.comfort.Comfort;
import by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias.ClientsComfortSquare;
import by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias.HoleOfficeSquare;
import by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias.WorkerComfortSquare;
import by.bseu.dss.buisnesslayer.criterias.location.Location;
import by.bseu.dss.buisnesslayer.criterias.location.subcriterias.AlphaBankLength;
import by.bseu.dss.buisnesslayer.criterias.location.subcriterias.District;
import by.bseu.dss.buisnesslayer.criterias.location.subcriterias.MetroLength;
import by.bseu.dss.buisnesslayer.criterias.office.Office;
import by.bseu.dss.buisnesslayer.criterias.office.subcriterias.InternetSpeed;
import by.bseu.dss.buisnesslayer.criterias.office.subcriterias.RepairingYear;
import by.bseu.dss.buisnesslayer.criterias.office.subcriterias.SharingPrice;

import static by.bseu.dss.buisnesslayer.criterias.methods.CriteriasMethods.*;
import static by.bseu.dss.buisnesslayer.criterias.building.subcriterias.BuildSubCriteriaMethods.*;
import static by.bseu.dss.buisnesslayer.criterias.comfort.subcriterias.ComfortSubCriteriasMethods.*;
import static by.bseu.dss.buisnesslayer.criterias.location.subcriterias.LocationSubCriteriasMethods.*;
import static by.bseu.dss.buisnesslayer.criterias.office.subcriterias.OfficeSubCriteriasMethods.*;
import static by.bseu.dss.buisnesslayer.alternatives.altmethods.AlternativeLogic.*;

public class Runner {

    public static void main(String[] args) {

        //Criterias
        Building building = makeBuilding();
        Comfort comfort = makeComfort(building);
        Location location = makeLocation(building, comfort);
        Office office = makeOffice(building, comfort, location);

        matrixPairComparison(building, comfort, location, office);

        double holeSum = sumAllValues(building, comfort, location, office);
        double[] lmbdBag = lambdaBag(lambdaBuilding(building, holeSum), lambdaComfort(comfort, holeSum),
                lambdaLocation(location, holeSum), lambdaOffice(office, holeSum));
        outputLmdBag(lmbdBag);
        setLmdToCriteria(building, comfort, location, office, lmbdBag);

        /*Criteria: building
        Subcriterias:
         */

        BuildingType buildingType = makeSubBuildingType();
        FloorNumber floorNumber = makeSubFloorNumber(buildingType);
        OutsideAppearance outsideAppearance = makeSubAppearance(buildingType, floorNumber);

        makeBuildSubMatrix(buildingType, floorNumber, outsideAppearance);

        double holeSumBuildSub = sumBuildSubAllValues(buildingType, floorNumber, outsideAppearance);
        double[] lmbdBuildSubBag = lambdaBuildSubBag(lambdaSubBuildType(buildingType ,holeSumBuildSub),
                lambdaSubBuildFloor(floorNumber, holeSumBuildSub),
                lambdaSubBuildAppearance(outsideAppearance, holeSumBuildSub));
        outputBuildSubLmdBag(lmbdBuildSubBag);
        setLmdToBuildSubcriterias(buildingType, floorNumber, outsideAppearance, lmbdBuildSubBag);

        /*Criteria: comfort
        Subcriterias:
         */

        ClientsComfortSquare clientsComfortSquare = makeSubClientsComfort();
        HoleOfficeSquare holeOfficeSquare = makeSubHoleOfficeSquare(clientsComfortSquare);
        WorkerComfortSquare workerComfortSquare = makeSubWorkerComfortSquare(clientsComfortSquare, holeOfficeSquare);

        makeComfortSubMatrix(clientsComfortSquare, holeOfficeSquare, workerComfortSquare);

        double holeSumComfort = sumComfortSubValues(clientsComfortSquare, holeOfficeSquare, workerComfortSquare);
        double[] lmbdComfortSubBag = lambdaComfortSubBag(lambdaSubComfortClients(clientsComfortSquare, holeSumComfort),
                lambdaSubComfortHoleOffice(holeOfficeSquare, holeSumComfort),
                lambdaSubComfortWorkerComf(workerComfortSquare, holeSumComfort));
        outputComfortSubLmdBag(lmbdComfortSubBag);
        setLmdToComfortSubcriterias(clientsComfortSquare, holeOfficeSquare, workerComfortSquare, lmbdComfortSubBag);

        /*Criteria: location
        Subcriterias:
         */

        AlphaBankLength alphaBankLength = makeSubBankLength();
        District district = makeSubDistrict(alphaBankLength);
        MetroLength metroLength = makeSubMetro(alphaBankLength, district);

        makeLocationSubMatrix(alphaBankLength, district, metroLength);

        double holeSumLocation = sumLocationSubValues(alphaBankLength, district, metroLength);
       double[] lmbdLocationSubBag = lambdaLocationSubBag(lambdaSubLocationBankLength(alphaBankLength, holeSumLocation),
      lambdaSubLocationDistrict(district, holeSumLocation), lambdaSubLocationMetroLength(metroLength, holeSumLocation));
       outputLocationSubLmdBag(lmbdLocationSubBag);
       setLmdToLocationSubcriterias(alphaBankLength, district, metroLength, lmbdLocationSubBag);

       /*Criteria: Office
       Subcriterias:
        */
        InternetSpeed internetSpeed = makeSubInternetSpeed();
        RepairingYear repairingYear = makeSubRepairingYear(internetSpeed);
        SharingPrice sharingPrice = makeSubSharingPrice(internetSpeed, repairingYear);

        makeOfficeSubMatrix(internetSpeed, repairingYear, sharingPrice);

        double holeSumOffice = sumOfficeSubValues(internetSpeed, repairingYear, sharingPrice);
        double[] lmbdOfficeSubBag = lambdaOfficeSubBag(lambdaSubOfficeInternetSpeed(internetSpeed, holeSumOffice),
                lambdaSubOfficeRepairingYear(repairingYear, holeSumOffice), lambdaSubOfficeSharingPrice(sharingPrice,
                        holeSumOffice));
        outputOfficeLmbdSubBag(lmbdOfficeSubBag);
        setLmdToOfficeSubCriterias(internetSpeed, repairingYear, sharingPrice, lmbdOfficeSubBag);

        /*
        Alternatives for Building subcriterias
         */

        System.out.println("Building type");
        Office1 office1Build = makeOffice1();
        Office2 office2Build = makeOffice2(office1Build);
        Office3 office3Build = makeOffice3(office1Build, office2Build);

        matrixPairComparison(office1Build, office2Build, office3Build);

        System.out.println("Subrciteria: Building type");
        double holeSumAltBuild = sumAllValuesAlt(office1Build, office2Build, office3Build);
        double[] lmbdAltBagBuild = lambdaBagAlt(lambdaOffice1(office1Build, holeSumAltBuild), lambdaOffice2(office2Build,
                holeSumAltBuild), lambdaOffice3(office3Build, holeSumAltBuild));
        outputLmdBagAlt(lmbdAltBagBuild);
        setLmdToAlt(office1Build, office2Build, office3Build, lmbdAltBagBuild);

        System.out.println("Floor number");
        Office1 office1Floor = makeOffice1();
        Office2 office2Floor = makeOffice2(office1Floor);
        Office3 office3Floor = makeOffice3(office1Floor, office2Floor);

        matrixPairComparison(office1Floor, office2Floor, office3Floor);

        System.out.println("Subrciteria: Floor number");
        double holeSumAltFloor = sumAllValuesAlt(office1Floor, office2Floor, office3Floor);
        double[] lmbdAltBagFloor = lambdaBagAlt(lambdaOffice1(office1Floor, holeSumAltFloor), lambdaOffice2(office2Floor,
                holeSumAltFloor), lambdaOffice3(office3Floor, holeSumAltFloor));
        outputLmdBagAlt(lmbdAltBagFloor);

        System.out.println("Outside appearance");
        Office1 office1Appear = makeOffice1();
        Office2 office2Appear = makeOffice2(office1Appear);
        Office3 office3Appear = makeOffice3(office1Appear, office2Appear);

        matrixPairComparison(office1Appear, office2Appear, office3Appear);

        System.out.println("Subrciteria: Outside appearance");
        double holeSumAltAppear = sumAllValuesAlt(office1Appear, office2Appear, office3Appear);
        double[] lmbdAltBagAppear = lambdaBagAlt(lambdaOffice1(office1Appear, holeSumAltAppear),
                lambdaOffice2(office2Appear, holeSumAltAppear), lambdaOffice3(office3Appear, holeSumAltAppear));
        outputLmdBagAlt(lmbdAltBagAppear);

        /*
        Alternatives for Comfort subcriterias
         */

        System.out.println("Clients comfort square");
        Office1 office1Clients = makeOffice1();
        Office2 office2Clients = makeOffice2(office1Clients);
        Office3 office3clients = makeOffice3(office1Clients, office2Clients);

        matrixPairComparison(office1Clients, office2Clients, office3clients);

        System.out.println("Subrciteria: Clients comfort square");
        double holeSumAltClients = sumAllValuesAlt(office1Clients, office2Clients, office3clients);
        double[] lmbdAltBagClients = lambdaBagAlt(lambdaOffice1(office1Clients, holeSumAltClients),
                lambdaOffice2(office2Clients, holeSumAltClients), lambdaOffice3(office3clients, holeSumAltClients));
        outputLmdBagAlt(lmbdAltBagClients);

        System.out.println("Hole office square");
        Office1 office1Square = makeOffice1();
        Office2 office2Square = makeOffice2(office1Square);
        Office3 office3Square = makeOffice3(office1Square, office2Square);

        matrixPairComparison(office1Square, office2Square, office3Square);

        System.out.println("Subrciteria: Hole office square");
        double holeSumAltSquare = sumAllValuesAlt(office1Square, office2Square, office3Square);
        double[] lmbdAltBagSquare = lambdaBagAlt(lambdaOffice1(office1Square, holeSumAltSquare),
                lambdaOffice2(office2Square, holeSumAltSquare), lambdaOffice3(office3Square, holeSumAltSquare));
        outputLmdBagAlt(lmbdAltBagSquare);

        System.out.println("Worker comfort square");
        Office1 office1Worker = makeOffice1();
        Office2 office2Worker = makeOffice2(office1Worker);
        Office3 office3Worker = makeOffice3(office1Worker, office2Worker);

        matrixPairComparison(office1Worker, office2Worker, office3Worker);

        System.out.println("Subrciteria: Worker comfort square");
        double holeSumAltWorker = sumAllValuesAlt(office1Worker, office2Worker, office3Worker);
        double[] lmbdAltBagWorker = lambdaBagAlt(lambdaOffice1(office1Worker, holeSumAltWorker),
                lambdaOffice2(office2Worker, holeSumAltWorker), lambdaOffice3(office3Worker, holeSumAltWorker));
        outputLmdBagAlt(lmbdAltBagWorker);

        /*
        Alternatives for Location subcriterias
         */

        System.out.println("Alpha bank length");
        Office1 office1Bank = makeOffice1();
        Office2 office2Bank = makeOffice2(office1Bank);
        Office3 office3Bank = makeOffice3(office1Bank, office2Bank);

        matrixPairComparison(office1Bank, office2Bank, office3Bank);

        System.out.println("Subrciteria: Alpha bank length");
        double holeSumAltBank = sumAllValuesAlt(office1Bank, office2Bank, office3Bank);
        double[] lmbdAltBagBank = lambdaBagAlt(lambdaOffice1(office1Bank, holeSumAltBank),
                lambdaOffice2(office2Bank, holeSumAltBank), lambdaOffice3(office3Bank, holeSumAltBank));
        outputLmdBagAlt(lmbdAltBagBank);

        System.out.println("District");
        Office1 office1District = makeOffice1();
        Office2 office2District = makeOffice2(office1District);
        Office3 office3District = makeOffice3(office1District, office2District);

        matrixPairComparison(office1District, office2District, office3District);

        System.out.println("Subrciteria: District");
        double holeSumAltDistrict = sumAllValuesAlt(office1District, office2District, office3District);
        double[] lmbdAltBagDistrict = lambdaBagAlt(lambdaOffice1(office1District, holeSumAltDistrict),
                lambdaOffice2(office2District, holeSumAltDistrict), lambdaOffice3(office3District, holeSumAltDistrict));
        outputLmdBagAlt(lmbdAltBagDistrict);

        System.out.println("Metro length");
        Office1 office1Metro = makeOffice1();
        Office2 office2Metro = makeOffice2(office1Metro);
        Office3 office3Metro = makeOffice3(office1Metro, office2Metro);

        matrixPairComparison(office1Metro, office2Metro, office3Metro);

        System.out.println("Subrciteria: Metro length");
        double holeSumAltMetro = sumAllValuesAlt(office1Metro, office2Metro, office3Metro);
        double[] lmbdAltBagMetro = lambdaBagAlt(lambdaOffice1(office1Metro, holeSumAltMetro),
                lambdaOffice2(office2Metro, holeSumAltMetro), lambdaOffice3(office3Metro, holeSumAltMetro));
        outputLmdBagAlt(lmbdAltBagMetro);

        /*
        Alternatives for Office subcriterias
         */

        System.out.println("Internet speed");
        Office1 office1Speed = makeOffice1();
        Office2 office2Speed = makeOffice2(office1Speed);
        Office3 office3Speed = makeOffice3(office1Speed, office2Speed);

        matrixPairComparison(office1Speed, office2Speed, office3Speed);

        System.out.println("Subrciteria: Internet speed");
        double holeSumAltSpeed = sumAllValuesAlt(office1Speed, office2Speed, office3Speed);
        double[] lmbdAltBagSpeed = lambdaBagAlt(lambdaOffice1(office1Speed, holeSumAltSpeed),
                lambdaOffice2(office2Speed, holeSumAltSpeed), lambdaOffice3(office3Speed, holeSumAltSpeed));
        outputLmdBagAlt(lmbdAltBagSpeed);

        System.out.println("Repairing year");
        Office1 office1Repairing = makeOffice1();
        Office2 office2Repairing = makeOffice2(office1Repairing);
        Office3 office3Repairing = makeOffice3(office1Repairing, office2Repairing);

        matrixPairComparison(office1Repairing, office2Repairing, office3Repairing);

        System.out.println("Subrciteria: Repairing year");
        double holeSumAltRepairing = sumAllValuesAlt(office1Repairing, office2Repairing, office3Repairing);
        double[] lmbdAltBagRepairing = lambdaBagAlt(lambdaOffice1(office1Repairing, holeSumAltRepairing),
                lambdaOffice2(office2Repairing, holeSumAltRepairing), lambdaOffice3(office3Repairing, holeSumAltRepairing));
        outputLmdBagAlt(lmbdAltBagRepairing);

        System.out.println("Sharing price");
        Office1 office1Price = makeOffice1();
        Office2 office2Price = makeOffice2(office1Price);
        Office3 office3Price = makeOffice3(office1Price, office2Price);

        matrixPairComparison(office1Price, office2Price, office3Price);

        System.out.println("Subrciteria: Sharing price");
        double holeSumAltPrice = sumAllValuesAlt(office1Price, office2Price, office3Price);
        double[] lmbdAltBagPrice = lambdaBagAlt(lambdaOffice1(office1Price, holeSumAltPrice),
                lambdaOffice2(office2Price, holeSumAltPrice), lambdaOffice3(office3Price, holeSumAltPrice));
        outputLmdBagAlt(lmbdAltBagPrice);

        double[][] result = convertToArr(lmbdAltBagBuild, lmbdAltBagFloor, lmbdAltBagAppear, lmbdAltBagClients,
               lmbdAltBagSquare, lmbdAltBagWorker, lmbdAltBagBank, lmbdAltBagDistrict, lmbdAltBagMetro, lmbdAltBagSpeed,
               lmbdAltBagRepairing, lmbdAltBagPrice);

        outputAltMat(result);

        double[] smth = allLmbdSub(lmbdBuildSubBag, lmbdComfortSubBag, lmbdLocationSubBag, lmbdOfficeSubBag);
        readyChoice(readyMark(result, smth));
    }
}
