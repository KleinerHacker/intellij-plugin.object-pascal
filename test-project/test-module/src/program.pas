program MyProgram;

uses MyUnit;

const
    myConst = 'my''string';
    myValueConst : real = 12.0;
    //myArrayConst : array [1..100] of integer; //TODO

type
    tMyEnum = (Jan, Feb, Mar);
    tMyRange = 10..20;
    tMyArray = array[tMyRange,1..10] of real;
    tMyRecord = record
        val1 : real;
        val2, val3 : tMyEnum;
    end;
    tMyObject = object
        val1 : integer;
        function GetVal1 : integer;
        procedure SetVal1(val1 : integer);
    end;
    tMyClass = class
        private
            val1 : string[100];
        public
            function GetVal1 : integer;
            procedure SetVal1(val1 : integer);
        published
            property Value1 : integer read GetVal1 write SetVal1;
    end;

var
    instance : tMyClass;

function tMyClass.GetVal1 : integer;
begin
    result := self.val1;
end;

procedure tMyClass.SetVal1(val1 : integer);
var
    a : real;
begin
    self.val1 := val1;
end;

begin
    instance := tMyClass.Create;
    instance.Value1 := 10;
    tMyClass(instance).Value1 := 9;
    tAny(tMyClass(instance).Value1).val := 9;

    for index := tMinValue to 10 do
    begin
        if indexer < (8-instance.Value1) then
        begin
            with instance do
            begin
                Value1 := indexer;
            end;
        end;
    end;
end