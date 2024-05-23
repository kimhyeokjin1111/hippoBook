export function remove(idList,callback){
    let param = '?';
    idList.forEach(id => param += 'id='+id + '&');
    param = param.slice(0, -1);

    fetch(`/v1/messages${param}`, {
        method: 'DELETE',
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}

export function remove2(idList,callback){
    let param = '?';
    idList.forEach(id => param += 'id='+id + '&');
    param = param.slice(0, -1);

    fetch(`/v2/messages${param}`, {
        method: 'DELETE',
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}