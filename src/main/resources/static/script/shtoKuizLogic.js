$(function() {

    $(document).on(
        'click',
        '[data-role="dynamic-fields"] > .form-inline [data-role="remove"]',
        function(e) {
            e.preventDefault();
            $(this).closest('.form-inline').remove();
        }
    );


    $(document).on(
        'click',
        '[data-role="dynamic-fields"] > .form-inline [data-role="add"]',
        function(e) {
            e.preventDefault();
            var container = $(this).closest('[data-role="dynamic-fields"]');
            new_field_group = container.children().filter('.form-inline:first-child').clone();
            new_field_group.find('input').each(function(){
                $(this).val('');
            });
            container.append(new_field_group);
        }
    );
});

$(document).ready(function(){
    //@naresh action dynamic childs
    var next_exp = 0;
    $("#add-more").click(function(e){
        e.preventDefault();
        var addto = "#fielda" + next_exp;
        var addRemove = "#fielda" + (next_exp);
        next_exp = next_exp + 1;
        var newInp = '<div id="fielda'+ next_exp +'" name="field1'+ next_exp +'"><hr/> <div class="form-group"> <label for="question">Pyetja</label> <textarea name="question" type="text" class="form-control" id="question" placeholder="Shenonin Pyetjen" style="resize:vertical;" required></textarea>   ' +
            ' <label for="question1">OpsioniA</label> <textarea name="optionAName"  type="text" class="form-control" id="question1" placeholder="Shenonin OpsioninA" style="resize:vertical;" required></textarea> <label for="question2">OpsioniB</label> <textarea name="optionBName"  type="text" class="form-control" id="question2"  placeholder="Shenonin OpsioninB" style="resize:vertical;" required></textarea> <label for="question3">OpsioniC</label> <textarea name="optionCName" type="text" class="form-control" id="question3"  placeholder="Shenonin OpsioninC" style="resize:vertical;" required></textarea> <label for="question4">OpsioniD</label> <textarea name="optionDName"  type="text" class="form-control" id="question4" placeholder="Shenonin OpdioninD" style="resize:vertical;" required></textarea> <label for="question5">Pergjigjja e Saket</label> <textarea  name="correctAnswerName"  type="text" class="form-control" id="question5"  placeholder="Shenoni pergjijgjen e sakt" style="resize:vertical;" required></textarea></div> <!--<div class="form-group"></div> <div class="form-group">--> <!--<label for="options">Options</label>--> <!-- <div class="form-group"> <div class="col-md-12">--> <!--<input type="radio" name="reason" value="Answer"> Answer <span>-</span>--> <!--<label class="sr-only" for="field-name">Option</label>  </div> </div>--> <!--<button class="btn btn-danger" data-role="remove"> <span class="glyphicon glyphicon-remove"></span> </button> <button class="btn btn-primary" data-role="add"> <span class="glyphicon glyphicon-plus"></span> </button>--> <!--</div> </div> </div>-->  <div class="form-group"> <label for="csetitle">Piket</label> <input name="piketName"  type="number" class="form-control" id="question"  placeholder="Shenoni piket e pyetjes" required><hr/></div></div>';
        var newInput = $(newInp);

        var removeBtn = '<div class="form-group"><button id="remove' + (next_exp - 1) + '" class="btn btn-danger remove-me" >Remove</button></div></div></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#fielda" + next_exp).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next_exp);

        $('.remove-me').click(function(e){
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length-1);
            var fieldID = "#fielda" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        });
    });



});
