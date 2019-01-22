package com.devopire32.server

import spock.lang.Specification
import spock.lang.Unroll

class SampleClassToTestSpockTest extends Specification {

//    SampleClassToTestSpock sampleClassToTestSpock

//    void setup() {
//        sampleClassToTestSpock = new SampleClassToTestSpock();
//    }

    @Unroll
    def "Is #a Equal To One [ #b ]"() {
        given:
//        def a =2
        SampleClassToTestSpock sampleClassToTestSpock = new SampleClassToTestSpock();

        expect:
        b == sampleClassToTestSpock.isEqualToOne(a)


        where:
        a || b
        1 || true
        2 || false
        3 || false
        0 || false
    }

    def "Mock example with Warehouse" (){
        given:
        def order =  new SampleClassToTestSpock("Jameson",34)
        Warehouse warehouse = Mock()

        when:
        warehouse.hasInventory("Jameson",34) >> true
        order.fill(warehouse)

        then:
        order.orderFilled
        1 * warehouse.remove("Jameson",34)
    }

    def "Do not fill order when inventory not present" (){
        given:
        def order = new SampleClassToTestSpock("Jim Beam", 123)
        Warehouse warehouse = Mock()

        when:
        order.fill(warehouse)
        warehouse.hasInventory(_,_)>> false
//        order.orderFilled

        then:
        !order.orderFilled
        0 * warehouse.remove(_,_)
        1 * warehouse.hasInventory(_,_)

    }


}
