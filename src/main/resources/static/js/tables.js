let add_table = document.getElementById('add_table');
add_table.addEventListener('click', addTable);
function addTable(){

    let tables_count = document.getElementById('tables_count').value;
    let tables = document.getElementById('tables');
    while (tables.firstChild) {
            tables.removeChild(tables.firstChild);
        }
    for(let i = 0; i < tables_count; i++){
        let table = document.createElement('div');
        let label = document.createElement('label');
        let input = document.createElement('input');
        input.setAttribute("type", "number");
        input.setAttribute("name", "count");
        label.appendChild(document.createTextNode('Введите количество мест для стола ' + (i+1) + " "));
        label.appendChild(input);
        table.appendChild(label);
        tables.appendChild(table);
    }
}