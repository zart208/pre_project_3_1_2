var editModal = document.getElementById('editModal')
editModal.addEventListener('show.bs.modal', function (event) {
    // Button that triggered the modal
    var button = event.relatedTarget
    // Extract info from data-bs-* attributes
    var recipient = button.getAttribute('data-bs-whatever')
    // If necessary, you could initiate an AJAX request here
    // and then do the updating in a callback.
    //
    // Update the modal's content.
    var modalTitle = editModal.querySelector('.modal-title')
    var modalBodyInput = editModal.querySelector('.modal-body input')

    //modalTitle.textContent = 'New message to ' + recipient
    //modalBodyInput.value = recipient
})

var deleteModal = document.getElementById('deleteModal')
editModal.addEventListener('show.bs.modal', function (event) {
    // Button that triggered the modal
    var button = event.relatedTarget
    // Extract info from data-bs-* attributes
    var recipient = button.getAttribute('data-bs-whatever')
    // If necessary, you could initiate an AJAX request here
    // and then do the updating in a callback.
    //
    // Update the modal's content.
    var modalTitle = deleteModal.querySelector('.modal-title')
    var modalBodyInput = deleteModal.querySelector('.modal-body input')

    //modalTitle.textContent = 'New message to ' + recipient
    //modalBodyInput.value = recipient
})